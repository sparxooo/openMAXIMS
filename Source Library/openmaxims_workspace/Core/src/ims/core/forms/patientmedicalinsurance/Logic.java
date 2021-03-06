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
// This code was generated by Peter Martin using IMS Development Environment (version 1.80 build 4261.20360)
// Copyright (C) 1995-2011 IMS MAXIMS. All rights reserved.

package ims.core.forms.patientmedicalinsurance;

import java.util.ArrayList;

import ims.configuration.gen.ConfigFlag;
import ims.core.forms.patientmedicalinsurance.GenForm.grdInsuranceRow;
import ims.core.vo.PatientMedicalInsuranceVo;
import ims.core.vo.PatientMedicalInsuranceVoCollection;
import ims.core.vo.PrivateInsuranceCompanyVoCollection;
import ims.core.vo.lookups.PrivateInsurancePolicyType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.framework.Control;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	
	//---------------------------------------------------------------------------------------------------------------------
	//	Event handlers
	//---------------------------------------------------------------------------------------------------------------------
	
	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	

	@Override
	protected void onFormModeChanged() 
	{
		updateControlsState();
	}

	
	@Override
	protected void onGrdInsuranceSelectionChanged() throws PresentationLogicException 
	{
		form.getLocalContext().setPatientMedicalInsuranceVo(domain.getPatientMedicalInsuranceVo(form.grdInsurance().getValue()));
		// Populate instance controls with selected record
		populateInstanceControlsFromData(form.getLocalContext().getPatientMedicalInsuranceVo());

		// Update controls state (buttons, context menu options, etc.)
		updateControlsState();
	}
	

	@Override
	protected void onBtnNewClick() throws ims.framework.exceptions.PresentationLogicException
	{
		newInstance();
	}
	

	@Override
	protected void onBtnUpdateClick() throws ims.framework.exceptions.PresentationLogicException
	{
		updateInstance();
	}
	

	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		if(save())
			open();
	}
	

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		open();
	}
	
	
	@Override
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException 
	{
		switch (menuItemID)
		{
			case GenForm.ContextMenus.GenericGrid.Add:
				newInstance();
				break;
				
			case GenForm.ContextMenus.GenericGrid.Update:
				updateInstance();
				break;
		}	
		
		updateControlsState();
	}

	
	@Override
	protected void onCmbPolicyTypeValueChanged() throws PresentationLogicException
	{
		if (!PrivateInsurancePolicyType.OTHER.equals(form.ctnDetails().cmbPolicyType().getValue()))
			form.ctnDetails().txtOther().setValue(null);
		
		updateControlsState();
	}

	
	
	//---------------------------------------------------------------------------------------------------------------------
	//	Form presentation functions
	//---------------------------------------------------------------------------------------------------------------------
	
	
	private void initialize() 
	{
		form.getLocalContext().setPatientMedicalInsuranceVo(null);
		// Initialize context menu
		form.getContextMenus().hideAllGenericGridMenuItems();

		form.getContextMenus().getGenericGridAddItem().setText("New");
		form.getContextMenus().getGenericGridUpdateItem().setText("Edit");
		
		populateCompanyCombo();		
	}
	

	private void open() 
	{
		clear();
		populatePatientMedicalInsuranceGrid(domain.listPatientMedicalInsuranceVo(form.getGlobalContext().Core.getPatientShort()));
		
		if(form.getLocalContext().getPatientMedicalInsuranceVoIsNotNull())
		{
			form.getLocalContext().setPatientMedicalInsuranceVo(domain.getPatientMedicalInsuranceVo(form.getLocalContext().getPatientMedicalInsuranceVo()));
		}
		
		form.grdInsurance().setValue(form.getLocalContext().getPatientMedicalInsuranceVo());
		populateInstanceControlsFromData(form.getLocalContext().getPatientMedicalInsuranceVo());
		
		form.setMode(FormMode.VIEW);
	}
	
	
	private void newInstance() 
	{
		// Clear local context selection
		form.getLocalContext().setPatientMedicalInsuranceVo(null);
		
		// Clear instance controls
		clearInstanceControls();
		// Set form to EDIT mode
		form.setMode(FormMode.EDIT);		
	}
	

	private void updateInstance() 
	{
		form.setMode(FormMode.EDIT);		
	}
	
	
	private boolean save() 
	{
		try
		{
			// Populate instance data from screen
			
			PatientMedicalInsuranceVo  psavo = populateDataFromInstanceControls(form.getLocalContext().getPatientMedicalInsuranceVo());

			// Validate instance data
			String[] errors = psavo.validate(validateUIRules());

			if (errors != null && errors.length > 0)
			{
				engine.showErrors(errors);
				return false;
			}
			form.getLocalContext().setPatientMedicalInsuranceVo(psavo);	
			// Attempt to save
			form.getLocalContext().setPatientMedicalInsuranceVo(domain.savePatientMedicalInsuranceVo(form.getLocalContext().getPatientMedicalInsuranceVo()));
			
			// Save was successful
			return true;
		}
		// Treat exceptions
		catch (StaleObjectException e)
		{
			
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return false;
		}
		catch (UnqViolationUncheckedException e)
		{
			engine.showMessage(e.getMessage());
			return false;
		}
	}
	

	private String[] validateUIRules()
	{
		ArrayList<String> listOfErrors = new ArrayList<String>();
		if( form.ctnDetails().cmbCompany().getValue() == null )		//wdev-19528
		{
			listOfErrors.add("Insurer is mandatory.");
		}
		
		if (PrivateInsurancePolicyType.OTHER.equals(form.ctnDetails().cmbPolicyType().getValue()) && form.ctnDetails().txtOther().getValue() == null)
		{
			listOfErrors.add("Other policy type is mandatory.");
		}

		return listOfErrors.toArray(new String[listOfErrors.size()]);
	}


	private void updateControlsState() 
	{
		form.ctnDetails().lblOther().setVisible(PrivateInsurancePolicyType.OTHER.equals(form.ctnDetails().cmbPolicyType().getValue()));
		form.ctnDetails().txtOther().setEnabled(FormMode.EDIT.equals(form.getMode()));
		form.ctnDetails().txtOther().setVisible(PrivateInsurancePolicyType.OTHER.equals(form.ctnDetails().cmbPolicyType().getValue()));
		
		// Update controls for VIEW mode
		if (FormMode.VIEW.equals(form.getMode()))
		{
			// EDIT button
			form.btnUpdate().setEnabled(true);
			form.btnUpdate().setVisible(form.grdInsurance().getValue() instanceof PatientMedicalInsuranceVo);
		}
		
		form.ctnDetails().setCollapsed(!(form.grdInsurance().getValue() != null || FormMode.EDIT.equals(form.getMode())));
		
		// Update context menu options
		updateContextMenuState();	
	}
	
	
	private void updateContextMenuState() 
	{
		form.getContextMenus().getGenericGridAddItem().setVisible(FormMode.VIEW.equals(form.getMode()));
		form.getContextMenus().getGenericGridUpdateItem().setVisible(form.grdInsurance().getValue() instanceof PatientMedicalInsuranceVo);	
	}
	

	
	//---------------------------------------------------------------------------------------------------------------------
	//	Data - screen exchange function
	//---------------------------------------------------------------------------------------------------------------------

	
	private void clear() 
	{
		form.grdInsurance().getRows().clear();
		clearInstanceControls();		
	}

	
	private void populatePatientMedicalInsuranceGrid(PatientMedicalInsuranceVoCollection collection) 
	{
		// Clear grid
		form.grdInsurance().getRows().clear();
		
		// Terminate function on null value parameter
		if (collection == null)
			return;
				
		// Iterate through pasconfig collection
		for (PatientMedicalInsuranceVo voPatientMedicalInsurance : collection)
		{
			if (voPatientMedicalInsurance == null)
				continue;
			
			// Add each pasconfig to a grid row
			grdInsuranceRow grdInsurance = form.grdInsurance().getRows().newRow(true);
			
			// Set pasconfigvo row columns
			if(voPatientMedicalInsurance.getCompanyIsNotNull())
				grdInsurance.setColCompany(voPatientMedicalInsurance.getCompany().toString());
			grdInsurance.setColPolicyNumber(voPatientMedicalInsurance.getPolicyNumber());
			if(voPatientMedicalInsurance.getPolicyTypeIsNotNull())
				grdInsurance.setColPolicyType(voPatientMedicalInsurance.getPolicyType().getText());
			grdInsurance.setColAuthorisationNumber(voPatientMedicalInsurance.getAuthorisationNumber());
			if(voPatientMedicalInsurance.getExpiryDateIsNotNull())
				grdInsurance.setColExpiryDate(voPatientMedicalInsurance.getExpiryDate().toString());
			if(voPatientMedicalInsurance.getCurrentStatusIsNotNull())
				grdInsurance.setColStatus(voPatientMedicalInsurance.getCurrentStatus().getText());
			if(voPatientMedicalInsurance.getStatusChangeDateIsNotNull())
				grdInsurance.setColStatusChanged(voPatientMedicalInsurance.getStatusChangeDate().toString());
			
			grdInsurance.setColUnid(voPatientMedicalInsurance.getID_PatientMedicalInsurance().toString());
			
			grdInsurance.setValue(voPatientMedicalInsurance);
		}	
	}

	
	private void clearInstanceControls() 
	{
		form.ctnDetails().cmbCompany().setValue(null);
		form.ctnDetails().txtPolicyNumber().setValue(null);
		form.ctnDetails().cmbPolicyType().setValue(null);
		form.ctnDetails().txtAuthorisationNumber().setValue(null);
		form.ctnDetails().txtOther().setValue(null);
		form.ctnDetails().dteExpiryDate().setValue(null);
		form.ctnDetails().cmbCurrentStatus().setValue(null);
		form.ctnDetails().dteStatusChange().setValue(null);	
	}

	
	private void populateInstanceControlsFromData(PatientMedicalInsuranceVo patientMedicalInsuranceVo) 
	{
		//Clear instance controls
		clearInstanceControls();
		
		// Terminate function on null value parameter
		if (patientMedicalInsuranceVo == null)
			return;
		
		//Set value to instance controls
		if(patientMedicalInsuranceVo.getCompanyIsNotNull())
			form.ctnDetails().cmbCompany().setValue(patientMedicalInsuranceVo.getCompany());
		form.ctnDetails().txtPolicyNumber().setValue(patientMedicalInsuranceVo.getPolicyNumber());
		form.ctnDetails().cmbPolicyType().setValue(patientMedicalInsuranceVo.getPolicyType());
		form.ctnDetails().txtAuthorisationNumber().setValue(patientMedicalInsuranceVo.getAuthorisationNumber());
		form.ctnDetails().txtPolicyNumber().setValue(patientMedicalInsuranceVo.getPolicyNumber());
		form.ctnDetails().txtOther().setValue(patientMedicalInsuranceVo.getPlanOrUnits());
		form.ctnDetails().dteExpiryDate().setValue(patientMedicalInsuranceVo.getExpiryDate());
		form.ctnDetails().cmbCurrentStatus().setValue(patientMedicalInsuranceVo.getCurrentStatus());
		form.ctnDetails().dteStatusChange().setValue(patientMedicalInsuranceVo.getStatusChangeDate());	
	}
	
	
	private PatientMedicalInsuranceVo populateDataFromInstanceControls(PatientMedicalInsuranceVo patientMedicalInsuranceVo) 
	{
		if (patientMedicalInsuranceVo == null)
		{
			patientMedicalInsuranceVo = new PatientMedicalInsuranceVo();
		}
		
		if(patientMedicalInsuranceVo.getPatient()==null)
			patientMedicalInsuranceVo.setPatient(form.getGlobalContext().Core.getPatientShort());
		
		// Get instance data from screen
		patientMedicalInsuranceVo.setCompany(form.ctnDetails().cmbCompany().getValue());
		patientMedicalInsuranceVo.setPolicyNumber(form.ctnDetails().txtPolicyNumber().getValue());
		patientMedicalInsuranceVo.setPolicyType(form.ctnDetails().cmbPolicyType().getValue());
		patientMedicalInsuranceVo.setAuthorisationNumber(form.ctnDetails().txtAuthorisationNumber().getValue());
		patientMedicalInsuranceVo.setPolicyNumber(form.ctnDetails().txtPolicyNumber().getValue());
		patientMedicalInsuranceVo.setPlanOrUnits(form.ctnDetails().txtOther().getValue());
		patientMedicalInsuranceVo.setExpiryDate(form.ctnDetails().dteExpiryDate().getValue());
		patientMedicalInsuranceVo.setCurrentStatus(form.ctnDetails().cmbCurrentStatus().getValue());
		patientMedicalInsuranceVo.setStatusChangeDate(form.ctnDetails().dteStatusChange().getValue());
		
		return patientMedicalInsuranceVo;
	}

	
	private void populateCompanyCombo()
	{
		form.ctnDetails().cmbCompany().clear();
		
		PrivateInsuranceCompanyVoCollection list = domain.listCompanies();
		
		if(list != null)
		{
			for(int i = 0; i < list.size(); i++)
			{
				form.ctnDetails().cmbCompany().newRow(list.get(i), list.get(i).getName());
			}
		}		
	}
}
