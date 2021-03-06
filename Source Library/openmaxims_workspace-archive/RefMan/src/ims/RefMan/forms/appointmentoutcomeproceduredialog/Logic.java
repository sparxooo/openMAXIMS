// This code was generated by Cristian Belciug using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2013 IMS MAXIMS. All rights reserved.

package ims.RefMan.forms.appointmentoutcomeproceduredialog;

import ims.RefMan.forms.appointmentoutcomeproceduredialog.GenForm.grpFilterEnumeration;
import ims.RefMan.vo.PatientProcedureForAppointmentOutcomeVo;
import ims.clinical.vo.lookups.CodingItemType;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.enums.MosType;
import ims.core.vo.lookups.PatientProcedureStatus;
import ims.core.vo.lookups.SourceofInformation;
import ims.core.vo.lookups.Specialty;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Date;
import ims.vo.interfaces.IClinicalCodingValue;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize(args);
		open();
	}
	
	private void open()
	{
		populateScreenFromData(form.getGlobalContext().RefMan.getPatientProcedureForAppointmentOutcome());
		form.setMode(FormMode.EDIT);
	}

	private void populateScreenFromData(PatientProcedureForAppointmentOutcomeVo patientProcedure)
	{
		clearScreen();
		
		if(patientProcedure == null)
			return;
		
		form.ccProcedure().setValue(patientProcedure);
		form.chkPrimary().setValue(patientProcedure.getIsPrimary());
		form.cmbLaterality().setValue(patientProcedure.getProcLaterality());
		form.ccPerformedBy().setValue(patientProcedure.getPeformedBy());
		form.txtSite().setValue(patientProcedure.getSiteText());
	}

	private void clearScreen()
	{
		form.ccProcedure().clear();
		form.chkPrimary().setValue(null);
		form.cmbLaterality().setValue(null);
		form.txtSite().setValue(null);
	}

	private void initialize(Object[] args)
	{
		HcpLiteVo performedBy = null;
		
		if(args != null && args.length > 0)
		{
			if(args[0] instanceof Specialty)
			{
				form.getLocalContext().setSpecialty((Specialty) args[0]);
			}
			
			if(args.length > 1)
			{
				if(args[1] instanceof HcpLiteVo)
				{
					performedBy = (HcpLiteVo) args[1];
				}
				
				if(args.length > 2)
				{
					if(args[2] instanceof Date)
					{
						form.getLocalContext().setAppointmentDate((Date) args[2]);
					}
				}
			}
		}
		
		form.getLocalContext().setCareContext(domain.getCareContext(form.getGlobalContext().Scheduling.getBookingAppointmentRef()));
		
		form.grpFilter().setValue(grpFilterEnumeration.rdoAll);
		
		form.ccProcedure().setCodingItemType(CodingItemType.PROCEDURE);
		form.ccProcedure().setHotlist(false);
		
		if(form.getLocalContext().getSpecialty() != null)
		{
			form.ccProcedure().setHotlist(true);
			form.ccProcedure().setSpecialty(form.getLocalContext().getSpecialty());
			form.grpFilter().setValue(grpFilterEnumeration.rdoSpecialty);
		}
		
		form.ccProcedure().setIsRequired(true);
		form.ccProcedure().setParentEditing(true);
		form.ccProcedure().setEnabled(true);
		
		form.ccPerformedBy().initialize(MosType.HCP);
		if(performedBy == null)
		{
			Object user = domain.getHcpLiteUser();
			
			if(user instanceof HcpLiteVo)
			{
				performedBy = (HcpLiteVo) user;
			}
		}
		
		form.ccPerformedBy().setValue(performedBy);
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOkClick() throws PresentationLogicException
	{
		if(save())
			engine.close(DialogResult.OK);
	}

	private boolean save()
	{
		PatientProcedureForAppointmentOutcomeVo patientProcedure = populateDataFromScreen(form.getGlobalContext().RefMan.getPatientProcedureForAppointmentOutcome());
		
		String[] errors = patientProcedure.validate();
		if(errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return false;
		}
		
		form.getGlobalContext().RefMan.setPatientProcedureForAppointmentOutcome(patientProcedure);
		
		return true;
	}

	private PatientProcedureForAppointmentOutcomeVo populateDataFromScreen(PatientProcedureForAppointmentOutcomeVo patientProcedureForAppointmentOutcome)
	{
		if(patientProcedureForAppointmentOutcome == null)
			patientProcedureForAppointmentOutcome = new PatientProcedureForAppointmentOutcomeVo();
		else
			patientProcedureForAppointmentOutcome = (PatientProcedureForAppointmentOutcomeVo) patientProcedureForAppointmentOutcome.clone();
		
		if(patientProcedureForAppointmentOutcome.getID_PatientProcedure() == null)
		{
			patientProcedureForAppointmentOutcome.setEpisodeOfCare(form.getLocalContext().getCareContext() != null ? form.getLocalContext().getCareContext().getEpisodeOfCare() : null);
			patientProcedureForAppointmentOutcome.setCareContext(form.getLocalContext().getCareContext());		
			patientProcedureForAppointmentOutcome.setInfoSource(SourceofInformation.CLINICALCONTACT);
			patientProcedureForAppointmentOutcome.setProcDate(form.getLocalContext().getAppointmentDate() != null ? form.getLocalContext().getAppointmentDate().toPartialDate() : null);
		}
		
		if (patientProcedureForAppointmentOutcome.getProcedureStatus()==null)
			patientProcedureForAppointmentOutcome.setProcedureStatus(PatientProcedureStatus.PLANNED);
		
		IClinicalCodingValue procedureControlValue = form.ccProcedure().getValue();
		
		if(procedureControlValue != null)
		{
			if(procedureControlValue.getIClinicalCodingValue() instanceof ProcedureLiteVo)
			{
				patientProcedureForAppointmentOutcome.setProcedure((ProcedureLiteVo) procedureControlValue.getIClinicalCodingValue());
			}
			
			patientProcedureForAppointmentOutcome.setProcedureDescription(procedureControlValue.getIClinicalCodingValueDescription());
		}
		
		patientProcedureForAppointmentOutcome.setIsPrimary(form.chkPrimary().getValue());
		patientProcedureForAppointmentOutcome.setProcLaterality(form.cmbLaterality().getValue());
		patientProcedureForAppointmentOutcome.setSiteText(form.txtSite().getValue());
		patientProcedureForAppointmentOutcome.setPeformedBy(form.ccPerformedBy().getValue() instanceof HcpLiteVo ? (HcpLiteVo) form.ccPerformedBy().getValue() : null);
		
		return patientProcedureForAppointmentOutcome;
	}

	@Override
	protected void onRadioButtongrpFilterValueChanged() throws PresentationLogicException
	{
		form.ccProcedure().setHotlist(grpFilterEnumeration.rdoAll.equals(form.grpFilter().getValue()) ? false : (form.getLocalContext().getSpecialty() != null ? true : false));
		if(grpFilterEnumeration.rdoSpecialty.equals(form.grpFilter().getValue()))
		{
			if(form.getLocalContext().getSpecialty() == null)
			{
				form.grpFilter().setValue(grpFilterEnumeration.rdoAll);
			}
		}
	}

	@Override
	protected void onCcProcedureValueChanged() throws PresentationLogicException
	{
		if (form.ccProcedure().isAllSelected() != null && form.ccProcedure().isAllSelected().booleanValue())
		{
			form.grpFilter().setValue(grpFilterEnumeration.rdoAll);
			form.ccProcedure().setHotlist(false);
			form.ccProcedure().search();
		}
	}
}
