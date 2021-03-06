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
// This code was generated by Gabriel Maxim using IMS Development Environment (version 1.80 build 5256.13787)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.forms.casenotefolderrequestscancellationtasksettings;

import ims.admin.vo.CaseNoteFolderRequestsCancellationSettingsVo;
import ims.admin.vo.CaseNoteTrackingConfigVo;
import ims.framework.exceptions.FormOpenException;
import ims.framework.interfaces.IDynamicFormDataOperations;

public class Logic extends BaseLogic implements IDynamicFormDataOperations
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException, FormOpenException
	{
		initialise();
	}
	//public methods--------------------
	
	public void loadData()
	{
		CaseNoteFolderRequestsCancellationSettingsVo settingsVo = domain.getConfiguration(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		
		form.getLocalContext().setSelectedRecord(settingsVo);
		
		populateScreenFromData(settingsVo);
	}

	public String[] validateData()
	{
		return getData().validate();
	}
	
	public void saveData() throws Exception
	{
		CaseNoteFolderRequestsCancellationSettingsVo record  = getData();
		
		String[] errors = record.validate();
		
		if(errors != null && errors.length > 0)
			throw new Exception("Validation Errors");
		
		domain.saveConfiguration(record);		
	}
	
	public CaseNoteFolderRequestsCancellationSettingsVo getData()
	{
		CaseNoteFolderRequestsCancellationSettingsVo settingsVo = populateDataFromScreen(form.getLocalContext().getSelectedRecord());
		settingsVo.setConfiguredJobDetails(form.getGlobalContext().Admin.getCurrentJobConfiguration());
		
		return settingsVo;
	}

	private CaseNoteFolderRequestsCancellationSettingsVo populateDataFromScreen(CaseNoteFolderRequestsCancellationSettingsVo selectedRecord)
	{
		if (selectedRecord == null)
			selectedRecord = new CaseNoteFolderRequestsCancellationSettingsVo();
		
		selectedRecord.setFailedRecordsNo(form.intFailedReq().getValue());
		selectedRecord.setProcessedRequestsNo(form.intTotalReq().getValue());
		selectedRecord.setSuccessfulRequestsCancelledNo(form.intSuccessReq().getValue());
		
		return selectedRecord;
	}
	//-----------------------------------
	
	// private methods ------------------
	private void populateScreenFromData(CaseNoteFolderRequestsCancellationSettingsVo settingsVo)
	{
		clearControls(null);
		if (settingsVo == null)
			return;
		
		form.intTotalReq().setValue(settingsVo.getProcessedRequestsNo());
		form.intSuccessReq().setValue(settingsVo.getSuccessfulRequestsCancelledNo());	
		form.intFailedReq().setValue(settingsVo.getProcessedRequestsNo() != null ? settingsVo.getProcessedRequestsNo() - (settingsVo.getSuccessfulRequestsCancelledNo() != null ?  settingsVo.getSuccessfulRequestsCancelledNo() : 0) :  null);
			
	}
	private void initialise() throws FormOpenException 
	{
		CaseNoteTrackingConfigVo caseNoteTrackingConfig = domain.getCaseNoteTrackingConfig();
		
		if (caseNoteTrackingConfig == null)
			throw new FormOpenException("Configuration Not Found for Case Note Folder Tracking. Please complete it in Case Note Folder Tracking Configuration screen. ");
		clearControls(caseNoteTrackingConfig);
		
		
	}

	private void clearControls(CaseNoteTrackingConfigVo caseNoteTrackingConfig)
	{
		form.intFailedReq().setValue(null);
		form.intSuccessReq().setValue(null);
		form.intTotalReq().setValue(null);
		if (caseNoteTrackingConfig != null)
			form.lblBanner().setValue("* Open case note requests older than " +  caseNoteTrackingConfig.getRequestsOlderThan().toString() + (caseNoteTrackingConfig.getRequestsOlderThan().intValue() == 1 ?  " day" : " days") + " will be processed."); //http://jira/browse/WDEV-22369
	}	
	//---------------------------

}
