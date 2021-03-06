//#############################################################################
//#                                                                           #
//#  Copyright (C) <2015>  <IMS MAXIMS>                                       #
//#                                                                           #
//#  This program is free software: you can redistribute it and/or modify     #
//#  it under the terms of the GNU Affero General Public License as           #
//#  published by the Free Software Foundation, either version 3 of the       #
//#  License, or (at your option) any later version.                          # 
//#                                                                           #
//#  This program is distributed in the hope that it will be useful,          #
//#  but WITHOUT ANY WARRANTY; without even the implied warranty of           #
//#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the            #
//#  GNU Affero General Public License for more details.                      #
//#                                                                           #
//#  You should have received a copy of the GNU Affero General Public License #
//#  along with this program.  If not, see <http://www.gnu.org/licenses/>.    #
//#                                                                           #
//#  IMS MAXIMS provides absolutely NO GUARANTEE OF THE CLINICAL SAFTEY of    #
//#  this program.  Users of this software do so entirely at their own risk.  #
//#  IMS MAXIMS only ensures the Clinical Safety of unaltered run-time        #
//#  software that it builds, deploys and maintains.                          #
//#                                                                           #
//#############################################################################
//#EOH
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.codedrecordcc;

import ims.RefMan.forms.codedrecordcc.GenForm.GroupHistologyEnumeration;
import ims.RefMan.forms.codedrecordcc.GenForm.grdDiagnosesCodedRow;
import ims.RefMan.forms.codedrecordcc.GenForm.grdHRGRow;
import ims.RefMan.forms.codedrecordcc.GenForm.grdProceduresCodedRow;
import ims.RefMan.vo.ReferralExternalCodingItemVo;
import ims.RefMan.vo.ReferralExternalCodingVo;
import ims.clinical.vo.CodingCommentVo;
import ims.clinical.vo.lookups.CodingCommentType;
import ims.clinical.vo.lookups.HistologyStatus;
import ims.configuration.gen.ConfigFlag;
import ims.core.admin.pas.vo.AdmissionDetailRefVo;
import ims.core.admin.pas.vo.DischargedEpisodeRefVo;
import ims.core.admin.pas.vo.InpatientEpisodeRefVo;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormModeChanged()
	{
		updateControlsState();
	}
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	
	@Override
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		// TODO Add your code here.
	}
	
	private void updateControlsState()
	{
		form.txtCoderComment().setEnabled(false);
		//WDEV-21240
		Boolean hasFCE = form.getLocalContext().getCurrentRecord() != null && form.getLocalContext().getCurrentRecord().getFCE() != null;
		form.lblHistology().setVisible(hasFCE);
		form.GroupHistology().setVisible(hasFCE);
		form.btnRemoveHistologyDetails().setVisible(hasFCE && FormMode.VIEW.equals(form.getMode()));
		form.btnEditHistology().setVisible(hasFCE && FormMode.VIEW.equals(form.getMode()));	
		form.GroupHistology().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.btnRemoveHistologyDetails().setEnabled(FormMode.VIEW.equals(form.getMode()) && Boolean.TRUE.equals(hasFCE) && form.getLocalContext().getCurrentRecord().getFCE().getHistologyStatusIsNotNull());
		//21240 End
	}

	public void setCanEncodeRecord(Boolean canEncode)
	{
		form.getLocalContext().setbCanEncode(canEncode);
	}

	public Boolean canEncodeRecord()
	{
		return form.getLocalContext().getbCanEncode();
	}
	
	private void clearScreen()
	{
		form.grdDiagnosesCoded().getRows().clear();
		form.grdProceduresCoded().getRows().clear();
		form.grdHRG().getRows().clear();
	}
	
	public void setValue(ReferralExternalCodingVo referralCoding)
	{
		clearScreen();
		
		form.getLocalContext().setCurrentRecord(referralCoding);
		
		if(referralCoding != null && referralCoding.getCodingItems() != null)
		{
			for(ReferralExternalCodingItemVo item : referralCoding.getCodingItems())
			{
				addRow(item);
			}
		}
		if(referralCoding != null)
			populateHistology();
		form.txtCoderComment().setValue(getComments(referralCoding));
		
		updateControlsState();
	}

	//WDEV-21240
	private void populateHistology()
	{
		Boolean haveCodingStatus = form.getLocalContext().getCurrentRecordIsNotNull() && form.getLocalContext().getCurrentRecord().getFCEIsNotNull() && form.getLocalContext().getCurrentRecord().getFCE().getHistologyStatusIsNotNull();
		form.GroupHistology().setValue(haveCodingStatus ? 
										HistologyStatus.AWAITING.equals(form.getLocalContext().getCurrentRecord().getFCE().getHistologyStatus()) ? 
												GroupHistologyEnumeration.rdoAwaiting
												:GroupHistologyEnumeration.rdoReceived:
										GroupHistologyEnumeration.None);
	}

	private String getComments(ReferralExternalCodingVo referralCoding)
	{
		if(referralCoding == null || referralCoding.getFCE() == null || referralCoding.getFCE().getCodingComment() == null)
			return null;
		
		CodingCommentVo commenttext = null;
		
		for(int i=0; i<referralCoding.getFCE().getCodingComment().size(); i++)
		{
			if(referralCoding.getFCE().getCodingComment().get(i) == null || !CodingCommentType.EXTERNAL.equals(referralCoding.getFCE().getCodingComment().get(i).getCodingType()))
				continue;
			
			if(commenttext == null)
			{
				commenttext = referralCoding.getFCE().getCodingComment().get(i);
			}
			
			if(referralCoding.getFCE().getCodingComment().get(i).getAuthoringDateTime() != null && commenttext.getAuthoringDateTime() != null && referralCoding.getFCE().getCodingComment().get(i).getAuthoringDateTime().isGreaterThan(commenttext.getAuthoringDateTime()))
				commenttext = referralCoding.getFCE().getCodingComment().get(i);
		}
		
		return commenttext != null ? commenttext.getCommentText() : null;
	}

	private void addRow(ReferralExternalCodingItemVo item)
	{
		if(item == null)
			return;
		
		if(item.getICD10() != null)
		{
			addDianosisRow(item);
		}
		else if(item.getOPCS4() != null)
		{
			addProcedureRow(item);
		}
		if(item.getHRG() != null)
		{
			addHrgRow(item);
		}
	}

	private void addHrgRow(ReferralExternalCodingItemVo item)
	{
		if(item == null)
			return;
		
		grdHRGRow row = form.grdHRG().getRows().newRow();
		row.setColHRGCode(item.getHRG());
		row.setColDescription(item.getItemDescription());
		row.setCellColDescriptionTooltip(item.getItemDescription()); //WDEV-23275
		
		row.setValue(item);
	}

	private void addDianosisRow(ReferralExternalCodingItemVo item)
	{
		if(item == null)
			return;
		
		grdDiagnosesCodedRow row = form.grdDiagnosesCoded().getRows().newRow();
		
		row.setColDaggerAsterisk(item.getDaggerAsterisk());
		row.setColCodingCode(item.getICD10());
		
		StringBuffer description = new StringBuffer();
		
		if(item.getItemShortDescription() != null)
		{
			description.append(item.getItemShortDescription());
		}
		
		if(description.length() > 0)
		{
			description.append(" - ");
		}
		
		if(item.getItemDescription() != null)
		{
			description.append(item.getItemDescription());
		}
		
		row.setColCodingDescription(description.toString());
		row.setCellColCodingDescriptionTooltip(description.toString()); //WDEV-23275
		
		row.setValue(item);
	}

	private void addProcedureRow(ReferralExternalCodingItemVo item)
	{
		if(item == null)
			return;
		
		grdProceduresCodedRow row = form.grdProceduresCoded().getRows().newRow();
		
		row.setColProcedureCode(item.getOPCS4());
		
		StringBuffer description = new StringBuffer();
		
		if(item.getItemShortDescription() != null)
		{
			description.append(item.getItemShortDescription());
		}
		
		if(description.length() > 0)
		{
			description.append(" - ");
		}
		
		if(item.getItemDescription() != null)
		{	
			description.append(item.getItemDescription());
		}
		
		row.setColProcDescription(description.toString());
		row.setCellColProcDescriptionTooltip(description.toString()); //WDEV-23275
		
		row.setColPrimarySecondary(item.getPrimarySecondaryInd());
		row.setColProcedureConsultant(item.getProcConsandTheatreCode());	
    	row.setColProcedureDate(getFormatedProcedureDate(item.getProcedureDateTime()));
		
		row.setValue(item);
	}
	
	private String getFormatedProcedureDate(String procedureDate)
	{
		if(procedureDate == null)
			return null;
		
    	String pattern = "ddMMyyyy";
    	SimpleDateFormat format = new SimpleDateFormat(pattern);
    	java.util.Date date = null;
		try
		{
			date = format.parse(procedureDate);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
			return null;
		}
		
		if(date == null)
			return null;
		
    	Date d = new Date(date);
    	
    	return d != null ? d.toString() : null;
	}

	private boolean save(HistologyStatus status)
	{
		if(form.getLocalContext().getCurrentRecord() == null || form.getLocalContext().getCurrentRecord().getFCE() == null)
			return false;
		
		form.getLocalContext().getCurrentRecord().getFCE().setHistologyStatus(status);
		
		String[] errors = form.getLocalContext().getCurrentRecord().validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		try
		{
			domain.saveHistology(form.getLocalContext().getCurrentRecord(), form.getLocalContext().getCurrentAdmission(), form.getLocalContext().getCurrentDischargedEpisode(), form.getLocalContext().getCurrentInpatient());
		}
		catch (StaleObjectException e)
		{
			e.printStackTrace();
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			form.fireCustomControlValueChanged();
			return false;
		}
		
		return true;
	}

	public void initialise(AdmissionDetailRefVo admission, InpatientEpisodeRefVo inpatientEpisode, DischargedEpisodeRefVo dischargedEpisode)
	{
		form.getLocalContext().setCurrentAdmission(admission);
		form.getLocalContext().setCurrentDischargedEpisode(dischargedEpisode);
		form.getLocalContext().setCurrentInpatient(inpatientEpisode);
	}

	@Override
	protected void onRadioButtonGroupHistologyValueChanged() throws PresentationLogicException
	{
		//WDEV-21240
		GroupHistologyEnumeration value = form.GroupHistology().getValue();
		HistologyStatus hisStatus = null;
		
		if(GroupHistologyEnumeration.rdoAwaiting.equals(value))
			hisStatus = HistologyStatus.AWAITING;
		else
			hisStatus = HistologyStatus.RECEIVED;	
		
		if(save(hisStatus))
			form.fireCustomControlValueChanged();
		
		form.setMode(FormMode.VIEW);
		updateControlsState();
	}

	@Override
	protected void onBtnRemoveHistologyDetailsClick() throws PresentationLogicException 
	{
		if(save(null))
		{
			form.fireCustomControlValueChanged();
		}
		updateControlsState();
	}

	@Override
	protected void onBtnEditHistologyClick() throws PresentationLogicException 
	{
		form.setMode(FormMode.EDIT);
		updateControlsState();
	}
}
