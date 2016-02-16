//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by Alexie Ursache using IMS Development Environment (version 1.53 build 2572.17685)
// Copyright (C) 1995-2007 IMS MAXIMS plc. All rights reserved.

package ims.assessment.forms.patientassessmentcomp;

import ims.configuration.gen.ConfigFlag;
import ims.assessment.configuration.vo.UserDefinedObjectComponentRefVo;
import ims.assessment.vo.GraphicAssessmentShortVo;
import ims.assessment.vo.PatientAssessmentDataListVo;
import ims.assessment.vo.PatientAssessmentDataVo;
import ims.assessment.vo.PatientAssessmentListVo;
import ims.assessment.vo.PatientAssessmentVo;
import ims.assessment.vo.PatientAssessmentVoCollection;
import ims.assessment.vo.PatientUserDefinedObjectListVo;
import ims.assessment.vo.PatientUserDefinedObjectListVoCollection;
import ims.assessment.vo.PatientUserDefinedObjectVo;
import ims.assessment.vo.UserAssessmentLiteVo;
import ims.assessment.vo.UserDefinedObjectComponentVo;
import ims.assessment.vo.UserDefinedObjectListVo;
import ims.core.vo.AuthoringInformationVo;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.lookups.LookupHelper;
import ims.core.vo.lookups.PatientAssessmentStatusReason;
import ims.core.vo.lookups.PatientAssessmentStatusReasonCollection;
import ims.core.vo.lookups.UserDefinedAssessmentType;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.framework.Control;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.Alignment;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.enumerations.FormMode;
import ims.framework.exceptions.CodingRuntimeException;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.DateTime;
import ims.framework.utils.Image;

public class Logic extends BaseLogic
{
	// Dynamic Grid Column Identifiers
	private static final Integer	HEADER_COLUMN			= new Integer(-1);
	private static final Integer	STATUS_COLUMN			= new Integer(-2);
	private static final Integer	REASON_COLUMN			= new Integer(-3);
	private static final Integer	HELP_URL_COLUMN			= new Integer(-4);
	private static final Integer	AUTHORING_COLUMN		= new Integer(-5);

	// Dynamic Grid Column Width
	private static final int		HEADER_COLUMN_WIDTH		= 350;
	private static final int		STATUS_COLUMN_WIDTH		= 110;
	private static final int		REASON_COLUMN_WIDTH		= 120;
	private static final int		HELP_URL_COLUMN_WIDTH	= 50;
	private static final int		AUTHORING_COLUMN_WIDTH	= -1;
	
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initialize();
		open();
	}
	
	protected void onFormDialogClosed(ims.framework.FormName formName, ims.framework.enumerations.DialogResult result) throws ims.framework.exceptions.PresentationLogicException
	{
		if(result.equals(ims.framework.enumerations.DialogResult.OK))
		{
			if(formName.equals(form.getForms().Assessment.UserDefinedFormSelect))
			{
				ims.assessment.vo.UserDefinedObjectVo voUserDefinedObject = form.getGlobalContext().Core.getUserDefinedObjectSelected();
				if(voUserDefinedObject != null)
				{
					PatientUserDefinedObjectVo voPatientUserDefinedObject = populatePatientAssessmentFromUserDefinedObject(voUserDefinedObject);
					voPatientUserDefinedObject = savePatientAssessment(voPatientUserDefinedObject);
					if(voPatientUserDefinedObject != null)
					{
						PatientUserDefinedObjectListVo voPatientUserDefinedObjectList = domain.getPatientUserDefinedObjectList(voPatientUserDefinedObject);
						PatientAssessmentListVo firstPatientAssessment = addNewPatientAssessment(voPatientUserDefinedObjectList, true);
						if(firstPatientAssessment != null)
						{
							form.dyngrdAssessments().setValue(firstPatientAssessment);
							// Open either Graphic or User Assessment
							if (isGraphicAssessmentData())
								updateGraphicAssessment(true);
							else if (isUserAssessmentData())
								updateUserAssessment(true);
						}
					}
				}
			}
		}
	}

	private PatientUserDefinedObjectVo populatePatientAssessmentFromUserDefinedObject(ims.assessment.vo.UserDefinedObjectVo voUserDefinedObject)
	{
		if(voUserDefinedObject == null)
			throw new CodingRuntimeException("No UserDefinedObjectVo provided");
		
		PatientUserDefinedObjectVo voPatientUserDefinedObject = new PatientUserDefinedObjectVo();
		voPatientUserDefinedObject.setUserDefinedObject(voUserDefinedObject);
		
		if (voUserDefinedObject.getComponentsIsNotNull())
			voUserDefinedObject.getComponents().sort();
		
		for (int i = 0; voUserDefinedObject != null && i < voUserDefinedObject.getComponents().size(); i++)
		{
			PatientAssessmentVo voPatientAssessment = new PatientAssessmentVo();
			voPatientAssessment.setCareContext(form.getGlobalContext().Core.getCurrentCareContext());
			voPatientAssessment.setClinicalContact(form.getGlobalContext().Core.getCurrentClinicalContact());
			voPatientAssessment.setStatus(PatientAssessmentStatusReason.NOTCOMMENCED);
			voPatientAssessment.setAuthoringInformation(getAuthoringHCP());
			
			//Patient Assessment Data
			PatientAssessmentDataVo voPatientAssessmentData = new PatientAssessmentDataVo();
			voPatientAssessmentData.setGraphic(voUserDefinedObject.getComponents().get(i).getGraphic());
			voPatientAssessmentData.setUserAssessment(voUserDefinedObject.getComponents().get(i).getUserAssessment());
			voPatientAssessment.setAssessmentData(voPatientAssessmentData);
			
			//Patient Assessment Collection
			if(voPatientUserDefinedObject.getPatientAssessments() == null)
				voPatientUserDefinedObject.setPatientAssessments(new PatientAssessmentVoCollection());
			voPatientUserDefinedObject.getPatientAssessments().add(voPatientAssessment);
		}

		return voPatientUserDefinedObject;
	}

	private AuthoringInformationVo getAuthoringHCP()
	{
		AuthoringInformationVo voAuthoring = new AuthoringInformationVo();
		voAuthoring.setAuthoringDateTime(new DateTime());
		voAuthoring.setAuthoringHcp((HcpLiteVo) domain.getHcpLiteUser());
		return voAuthoring;
	}

	protected void onFormModeChanged()
	{
		updateControlsState();
		enableContextMenu();
	}
	protected void onDyngrdAssessmentsRowSelectionChanged(ims.framework.controls.DynamicGridRow row)
	{
		if(form.getMode().equals(FormMode.VIEW))
		{
			PatientAssessmentListVo voPatientAssessmentList = getSelectedPatientAssessment(row);
			form.getLocalContext().setVoPatientAssessment(voPatientAssessmentList);
			enableContextMenu();
		}
	}
	protected void onDyngrdAssessmentsCellValueChanged(DynamicGridCell cell)
	{
		//Refresh Reason Column
		DynamicGridColumn col = cell.getColumn();
		if(col != null && col.getIdentifier().equals(STATUS_COLUMN))
		{
			DynamicGridRow row = cell.getRow();
			if(row != null)
			{
				DynamicGridCell reasonCell = row.getCells().get(getDynGridColumn(REASON_COLUMN));
				Object statusValue = cell.getValue();
				if(reasonCell != null )
				{
					if(statusValue instanceof PatientAssessmentStatusReason)
					{
						populateReasonCell(reasonCell, (PatientAssessmentStatusReason)statusValue);
					}
					else
					{
						reasonCell.getItems().clear();
					}
				}
			}
		}
	}
	protected void onContextMenuItemClick(int menuItemID, Control sender) throws PresentationLogicException
	{
		switch(menuItemID)
		{
			case GenForm.ContextMenus.PatientAssessment.Add:
				addPatientAssessment();
			break;
			
			case GenForm.ContextMenus.PatientAssessment.Update:
				updatePatientAssessment();
			break;
			
			case GenForm.ContextMenus.PatientAssessment.AddGraphicAssessment:
				updateGraphicAssessment(true);
			break;
			
			case GenForm.ContextMenus.PatientAssessment.UpdateGraphicAssessment:
				updateGraphicAssessment(true);
			break;
						
			case GenForm.ContextMenus.PatientAssessment.ViewGraphicAssessment:
				updateGraphicAssessment(false);
			break;
			
			case GenForm.ContextMenus.PatientAssessment.AddUserAssessment:
				updateUserAssessment(true);
			break;			
			
			case GenForm.ContextMenus.PatientAssessment.UpdateUserAssessment:
				updateUserAssessment(true);
			break;
			
			case GenForm.ContextMenus.PatientAssessment.ViewUserAssessment:
				updateUserAssessment(false);
			break;
		}
	}

	protected void onBtnSaveClick() throws PresentationLogicException
	{
		if(save())
		{
			open();
		}
	}

	protected void onBtnCancelClick() throws PresentationLogicException
	{
		open();
	}
	
	protected void onDyngrdAssessmentsCellButtonClicked(DynamicGridCell cell)
	{
		if(cell != null)
		{
			if(cell.getColumn() != null && cell.getColumn().equals(getDynGridColumn(HELP_URL_COLUMN)))
			{
				if(cell.getIdentifier() != null)
				{
					Object identifier = cell.getIdentifier();
					if(identifier instanceof String)
					{
						engine.openUrl((String)identifier);
					}
				}
			}
		}
	}
	
	public void clearInstanceControls()
	{
		form.dyngrdAssessments().getRows().clear();
	}
	public void newInstance() throws PresentationLogicException
	{
		engine.open(form.getForms().Assessment.UserDefinedFormSelect);
	}
	public boolean save() throws PresentationLogicException
	{
		PatientAssessmentListVo voPatientAssessmentList = form.getLocalContext().getVoPatientAssessment();
		if(populateDataFromScreen(voPatientAssessmentList) == false)
			return false;
		
		voPatientAssessmentList = savePatientAssessmentList(voPatientAssessmentList);
		
		form.getLocalContext().setVoPatientAssessment(voPatientAssessmentList);
		form.getGlobalContext().Clinical.PatientAssessment.setSelectedAssessment(voPatientAssessmentList);
		
		return voPatientAssessmentList != null?true:false;
	}
	public void updateControlsState()
	{
		if(form.getMode().equals(FormMode.EDIT))
		{
			DynamicGridRow row = form.dyngrdAssessments().getSelectedRow();
			if(row == null)
				return;
			
			DynamicGridCell cell = row.getCells().get(getDynGridColumn(STATUS_COLUMN));
			if(cell != null)
				cell.setReadOnly(false);
			
			cell = row.getCells().get(getDynGridColumn(REASON_COLUMN));
			if(cell != null)
				cell.setReadOnly(false);
			
		}
	}
	public void updateInstance()
	{
		form.getLocalContext().setVoPatientAssessment(getSelectedPatientAssessment(form.dyngrdAssessments().getSelectedRow()));
		form.setMode(FormMode.EDIT);			
	}
	public void open() throws PresentationLogicException
	{
		form.setMode(FormMode.VIEW);
		clearInstanceControls();
		PatientUserDefinedObjectListVoCollection voColl = domain.listPatientUserDefinedObjects(form.getGlobalContext().Core.getCurrentCareContext());
		for (int i = 0; voColl != null && i < voColl.size(); i++)
		{
			displayRecords(voColl.get(i));	
		}
	}

	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
		if(form.getGlobalContext().Core.getCurrentCareContext() == null)
			throw new ims.framework.exceptions.FormOpenException("Please select a Care Context");

		initDynAssessmentGrid();
	}

	//---- Domain Interface method implementation ------------------------------------------
	/*public void setCurrentCareContext(CareContextShortVo careContext)
	{
		form.getLocalContext().setLocalCareContext(careContext);
	}

	public void setCurrentClinicalContact(ClinicalContactShortVo clinicalContact)
	{
		form.getLocalContext().setLocalClinicalContact(clinicalContact);
	}*/
		
	//---- End Domain Interface method implementation --------------------------------------
	
	//---- Private methods -----------------------------------------------------------------
	private PatientAssessmentListVo savePatientAssessmentList(PatientAssessmentListVo voPatientAssessmentList) throws PresentationLogicException
	{
		String[] errors = voPatientAssessmentList.validate();
		if(errors != null)
		{
			engine.showErrors(errors);
			return null;
		}
		
		try
		{
			voPatientAssessmentList = domain.savePatientAssessmentList(voPatientAssessmentList);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return null;
		}
		
		return voPatientAssessmentList;
	}
	
	private PatientUserDefinedObjectVo savePatientAssessment(PatientUserDefinedObjectVo voPatientUserDefindeObject) throws PresentationLogicException
	{
		String[] errors = voPatientUserDefindeObject.validate();
		if(errors != null)
		{
			engine.showErrors(errors);
			return null;
		}
		
		try
		{
			voPatientUserDefindeObject = domain.savePatientUserDefinedObject(voPatientUserDefindeObject);
		}
		catch (StaleObjectException e)
		{
			engine.showMessage(ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
			open();
			return null;
		}
		
		return voPatientUserDefindeObject;
	}
	private boolean populateDataFromScreen(PatientAssessmentListVo voPatientAssessment)
	{
		if(voPatientAssessment == null)
			return false;
		
		DynamicGridRow parentRow = getRowByValue(voPatientAssessment);
		if(parentRow == null)
			return false;
		
		DynamicGridCell status_cell = parentRow.getCells().get(getDynGridColumn(STATUS_COLUMN));
		if(status_cell != null)
		{
			Object value = status_cell.getValue();
			voPatientAssessment.setStatus(value instanceof PatientAssessmentStatusReason?(PatientAssessmentStatusReason)value:null);
		}
		DynamicGridCell reason_cell = parentRow.getCells().get(getDynGridColumn(REASON_COLUMN));
		if(reason_cell != null)
		{
			Object value = reason_cell.getValue();
			voPatientAssessment.setStatusReason(value instanceof PatientAssessmentStatusReason?(PatientAssessmentStatusReason)value:null);
		}

		return true;
	}

	private DynamicGridRow getRowByValue(PatientAssessmentListVo voPatientAssessmentList)
	{
		for(int i = 0; i < form.dyngrdAssessments().getRows().size(); i++)
		{
			DynamicGridRow row = form.dyngrdAssessments().getRows().get(i);
			Object value = row.getValue();
			if(value instanceof PatientAssessmentListVo && ((PatientAssessmentListVo)value).equals(voPatientAssessmentList))
				return form.dyngrdAssessments().getRows().get(i);
		}
		return null;
	}
	
	private void displayRecords(PatientUserDefinedObjectListVo voPatUserDefinedObjectList)
	{
		if(voPatUserDefinedObjectList == null || voPatUserDefinedObjectList.getPatientAssessments() == null)
			return;
		
		addNewPatientAssessment(voPatUserDefinedObjectList, voPatUserDefinedObjectList.equals(form.getGlobalContext().Assessment.getPatientUserDefinedObject()));
	}

	private PatientAssessmentListVo addNewPatientAssessment(PatientUserDefinedObjectListVo voPatUserDefinedObjectList, boolean expand)
	{
		if(voPatUserDefinedObjectList == null)
			return null;
		PatientAssessmentListVo firstPatientAssessment = null;
		DynamicGridRow rowParent = form.dyngrdAssessments().getRows().newRow();

		rowParent.setValue(voPatUserDefinedObjectList);
		rowParent.setExpanded(expand);		
		DynamicGridCell parent_cell = rowParent.getCells().get(getDynGridColumn(HEADER_COLUMN));
		if(parent_cell == null)
			parent_cell = rowParent.getCells().newCell(getDynGridColumn(HEADER_COLUMN), DynamicCellType.STRING);
		parent_cell.setReadOnly(true);
		parent_cell.setValue(getHeaderText(voPatUserDefinedObjectList.getUserDefinedObject()));
		
		for (int i = 0; i < voPatUserDefinedObjectList.getPatientAssessments().size(); i++)
		{
			PatientAssessmentListVo voPatientAssessmentList = voPatUserDefinedObjectList.getPatientAssessments().get(i);
			if(voPatientAssessmentList.getAssessmentDataIsNotNull())
			{
				PatientAssessmentDataListVo voPatientAssessmentData = voPatientAssessmentList.getAssessmentData();
				//Get the first Patient Assessment
				if (firstPatientAssessment == null)
					firstPatientAssessment = voPatientAssessmentList;
				DynamicGridRow childRow = rowParent.getRows().newRow();
				childRow.setSelectable(true);
				childRow.setExpanded(expand);	
				Image childImage = getImage(voPatientAssessmentData);
				childRow.setExpandedImage(childImage);
				childRow.setCollapsedImage(childImage);
				childRow.setValue(voPatientAssessmentList);
								
				DynamicGridCell child_cell = childRow.getCells().get(getDynGridColumn(HEADER_COLUMN));
				if(child_cell == null)
					child_cell = childRow.getCells().newCell(getDynGridColumn(HEADER_COLUMN), DynamicCellType.STRING);
				child_cell.setReadOnly(true);
				child_cell.setValue(getChildText(voPatientAssessmentData));
				child_cell.setIdentifier(voPatientAssessmentData);
				
				DynamicGridCell child_stat_cell = childRow.getCells().get(getDynGridColumn(STATUS_COLUMN));
				if(child_stat_cell == null)
				{
					child_stat_cell = childRow.getCells().newCell(getDynGridColumn(STATUS_COLUMN), DynamicCellType.ENUMERATION);
					populateStatusCell(child_stat_cell);
				}
				child_stat_cell.setAutoPostBack(true);
				child_stat_cell.setReadOnly(true);
				child_stat_cell.setValue(voPatientAssessmentList.getStatus());
				
				DynamicGridCell child_reason_cell = childRow.getCells().get(getDynGridColumn(REASON_COLUMN));
				if(child_reason_cell == null)
				{
					child_reason_cell = childRow.getCells().newCell(getDynGridColumn(REASON_COLUMN), DynamicCellType.ENUMERATION);
					populateReasonCell(child_reason_cell, voPatientAssessmentList.getStatus());
				}
				child_reason_cell.setReadOnly(true);
				child_reason_cell.setValue(voPatientAssessmentList.getStatusReason());
				
				
				Image imgLink  = form.getImages().Core.Information;
				String helpUrl = null;
				if(voPatientAssessmentData.getUserAssessmentIsNotNull())
					helpUrl = voPatientAssessmentData.getUserAssessment().getHelpURL();

				if(voPatientAssessmentData.getGraphicIsNotNull())
					helpUrl = voPatientAssessmentData.getGraphic().getHelpUrl();
				
				if(helpUrl != null && helpUrl.length() > 0)
				{
					DynamicGridCell help_url_cell = childRow.getCells().get(getDynGridColumn(HELP_URL_COLUMN));
					if(help_url_cell == null)
					{
						help_url_cell = childRow.getCells().newCell(getDynGridColumn(HELP_URL_COLUMN), DynamicCellType.IMAGEBUTTON);
					}
					help_url_cell.setValue(imgLink);
					help_url_cell.setTooltip(helpUrl);
					help_url_cell.setIdentifier(helpUrl);
					help_url_cell.setAutoPostBack(true);
				}
				
				DynamicGridCell authoring_cell = childRow.getCells().get(getDynGridColumn(AUTHORING_COLUMN));
				if(authoring_cell == null)
				{
					authoring_cell = childRow.getCells().newCell(getDynGridColumn(AUTHORING_COLUMN), DynamicCellType.STRING);
				}
				String auhtoringInfo = voPatientAssessmentList.getAuthoringInformationIsNotNull()?voPatientAssessmentList.getAuthoringInfo().toString(", "):"";
				authoring_cell.setValue(auhtoringInfo);
				authoring_cell.setTooltip(auhtoringInfo);
				authoring_cell.setReadOnly(true);
			}
		}
		
		return firstPatientAssessment;
	}
	private Image getImage(PatientAssessmentDataListVo voPatientAssessmentData)
	{
		if(voPatientAssessmentData != null)
		{
			if(voPatientAssessmentData.getUserAssessmentIsNotNull())
				return form.getImages().Core.TextBox;
			
			if(voPatientAssessmentData.getGraphicIsNotNull())
				return form.getImages().Admin.Color;
		}
		return null;
	}

	private void initDynAssessmentGrid()
	{
		form.dyngrdAssessments().clear();
		
		DynamicGridColumn column_parent = form.dyngrdAssessments().getColumns().getByIdentifier(HEADER_COLUMN);
		if(column_parent == null)
			column_parent = form.dyngrdAssessments().getColumns().newColumn("Patient Assessment", HEADER_COLUMN);
		column_parent.setWidth(HEADER_COLUMN_WIDTH);
		column_parent.setCanGrow(true);
				
		DynamicGridColumn column_status = form.dyngrdAssessments().getColumns().getByIdentifier(STATUS_COLUMN);
		if(column_status == null)
			column_status = form.dyngrdAssessments().getColumns().newColumn("Status", STATUS_COLUMN);
		column_status.setWidth(STATUS_COLUMN_WIDTH);
		column_status.setCanGrow(false);
						
		DynamicGridColumn column_reason = form.dyngrdAssessments().getColumns().getByIdentifier(REASON_COLUMN);
		if(column_reason == null)
			column_reason = form.dyngrdAssessments().getColumns().newColumn("Reason", REASON_COLUMN);
		column_reason.setWidth(REASON_COLUMN_WIDTH);
		column_reason.setCanGrow(false);
				
		DynamicGridColumn column_url_help = form.dyngrdAssessments().getColumns().getByIdentifier(HELP_URL_COLUMN);
		if(column_url_help == null)
			column_url_help = form.dyngrdAssessments().getColumns().newColumn("URL", HELP_URL_COLUMN);
		column_url_help.setWidth(HELP_URL_COLUMN_WIDTH);
		column_url_help.setCanGrow(false);
		column_url_help.setHeaderAlignment(Alignment.CENTER);
		column_url_help.setAlignment(Alignment.CENTER);
		
		DynamicGridColumn column_authoring = form.dyngrdAssessments().getColumns().getByIdentifier(AUTHORING_COLUMN);
		if(column_authoring == null)
			column_authoring = form.dyngrdAssessments().getColumns().newColumn("Authoring Information", AUTHORING_COLUMN);
		column_authoring.setWidth(AUTHORING_COLUMN_WIDTH);
		column_authoring.setCanGrow(false);
	}
	
	private DynamicGridColumn getDynGridColumn(Integer identifier)
	{
		return form.dyngrdAssessments().getColumns().getByIdentifier(identifier);
	}
	
	private String getHeaderText(UserDefinedObjectListVo voUserDefinedObjectList)
	{
		if(voUserDefinedObjectList != null)
		{
			StringBuffer text = new StringBuffer();
			if(voUserDefinedObjectList.getNameIsNotNull())
			{
				text.append("  ");
				text.append("Name: ");
				text.append(voUserDefinedObjectList.getName());
			}
			return text.toString();
		}
		
		return "";
	}
	
	private String getChildText(PatientAssessmentDataListVo voPatientAssessmentData)
	{
		if(voPatientAssessmentData != null)
		{
			StringBuffer text = new StringBuffer();
			if(voPatientAssessmentData.getUserAssessmentIsNotNull())
			{
				UserAssessmentLiteVo userAssessment = voPatientAssessmentData.getUserAssessment();
				text.append(userAssessment.getName());
				text.append(" - (" );
				if(userAssessment.getAssessmentTypeIsNotNull())
				{
					if(userAssessment.getAssessmentType().equals(UserDefinedAssessmentType.USERDEFINEDDATASHEET))
						text.append("Non Scoring ");
					else if(userAssessment.getAssessmentType().equals(UserDefinedAssessmentType.ASSESSMENTTOOL))
						text.append("Scoring ");
				}
				text.append("Assessment)");
				
				return text.toString();
			}
			else if(voPatientAssessmentData.getGraphicIsNotNull())
			{
				GraphicAssessmentShortVo voGraphic = voPatientAssessmentData.getGraphic();
				text.append(voGraphic.getName());
				text.append(" - (Graphical Assessment");
				if(voGraphic.getAssessmentTypeIsNotNull())
				{
					if(voGraphic.getAssessmentType().equals(UserDefinedAssessmentType.ANNOTATEDIMAGEWITHQUESTIONS))
						text.append(" with Questions");
				}
				text.append(")");
				return text.toString();
				
			}
		}
		return "";
	}
	
	private String getChildName(PatientAssessmentDataListVo voPatientAssessmentData)
	{
		if(voPatientAssessmentData != null)
		{
			if(voPatientAssessmentData.getUserAssessmentIsNotNull())
			{
				return voPatientAssessmentData.getUserAssessment().getName();
			}
			else if(voPatientAssessmentData.getGraphicIsNotNull())
			{
				return voPatientAssessmentData.getGraphic().getName();
			}
		}
		return null;
	}
	
	private void populateStatusCell(DynamicGridCell status_cell)
	{
		status_cell.getItems().clear();
		PatientAssessmentStatusReasonCollection voColl = LookupHelper.getPatientAssessmentStatusReason(domain.getLookupService());
		for(int i = 0; voColl != null && i < voColl.size(); i++)
		{
			if(voColl.get(i).getParent() == null)
				status_cell.getItems().newItem(voColl.get(i));
		}
	}
	
	private void populateReasonCell(DynamicGridCell reason_cell, PatientAssessmentStatusReason parent)
	{
		reason_cell.getItems().clear();
		PatientAssessmentStatusReasonCollection voColl = LookupHelper.getPatientAssessmentStatusReason(domain.getLookupService());
		for(int i = 0; voColl != null && i < voColl.size(); i++)
		{
			if(voColl.get(i).getParent() != null && voColl.get(i).getParent().equals(parent))
				reason_cell.getItems().newItem(voColl.get(i));
		}			
	}
	
	private void addPatientAssessment() throws PresentationLogicException
	{
		newInstance();
	}
	
	private void updatePatientAssessment()
	{
		updateInstance();
	}

	private void updateGraphicAssessment(boolean editComponent)
	{
		PatientUserDefinedObjectListVo voPatientUserDefinedObjectList = getParentPatientUserDefinedObjectList();
		if(voPatientUserDefinedObjectList == null)
		{
			displayError("Please select a Patient User Defined Object");
			return; 
		}
		PatientAssessmentListVo voPatientAssessmentList = getPatientAssessmentFromGrid();
		if(voPatientAssessmentList == null)
		{
			displayError("Please select a Patient Assessment");
			return; 
		}
		PatientAssessmentDataListVo voPatientAssessmentData = voPatientAssessmentList.getAssessmentData();
		if(voPatientAssessmentData == null)
		{
			displayError("Please select a Graphic Patient Assessment Data");
			return;
		}
		PatientUserDefinedObjectVo voPatientUserDefinedObjectVo = domain.getPatientUserDefinedObject(voPatientUserDefinedObjectList);
		UserDefinedObjectComponentRefVo editedComponent = getEditedComponent(voPatientUserDefinedObjectVo);
		if(editedComponent == null)
		{
			displayError("Please select a User Defined Object Component");
			return; 
		}
		
		form.getGlobalContext().Clinical.PatientAssessment.setEditComponent(new Boolean(editComponent));
		form.getGlobalContext().Clinical.PatientAssessment.setEditedComponent(editedComponent);
		form.getGlobalContext().Clinical.PatientAssessment.setSelectedAssessment(voPatientAssessmentList);
		form.getGlobalContext().Assessment.setPatientUserDefinedObject(voPatientUserDefinedObjectVo);
		engine.open(form.getForms().Assessment.GraphicAssessmentInstantiation);	
	}
	
	private void updateUserAssessment(boolean updateAssessment)
	{
		PatientUserDefinedObjectListVo voPatientUserDefinedObjectList = getParentPatientUserDefinedObjectList();
		if(voPatientUserDefinedObjectList == null)
		{
			displayError("Please select a Patient User Defined Object");
			return; 
		}
		PatientAssessmentListVo voPatientAssessmentList = getPatientAssessmentFromGrid();
		if(voPatientAssessmentList == null)
		{
			displayError("Please select a Patient Assessment");
			return; 
		}
		
		PatientAssessmentDataListVo voPatientAssessmentData = voPatientAssessmentList.getAssessmentData();
		if(voPatientAssessmentData == null)
		{
			displayError("Please select a Patient Assessment Data");
			return;
		}
		
		PatientUserDefinedObjectVo voPatientUserDefinedObjectVo = domain.getPatientUserDefinedObject(voPatientUserDefinedObjectList);
		UserDefinedObjectComponentRefVo editedComponent = getEditedComponent(voPatientUserDefinedObjectVo);
		if(editedComponent == null)
		{
			displayError("Please select a User Defined Object Component");
			return; 
		}
		form.getGlobalContext().Clinical.PatientAssessment.setEditComponent(new Boolean(updateAssessment));
		form.getGlobalContext().Clinical.PatientAssessment.setEditedComponent(editedComponent);
		form.getGlobalContext().Clinical.PatientAssessment.setSelectedAssessment(voPatientAssessmentList);
		form.getGlobalContext().Assessment.setPatientUserDefinedObject(voPatientUserDefinedObjectVo);
		
		//TODO - to be saved in local context and provide a Domain Interface method to get value of the Return to
		//Also please revisit all the references of this component where getReturnToFormName is used 
		form.getGlobalContext().Clinical.setReturnToFormName(form.getForms().Assessment.PatientAssessment);
		
		engine.open(form.getForms().Assessment.UserAssessmentInstantiationWithComponent);
	}
	
	private void enableContextMenu()
	{
		boolean viewMode = form.getMode().equals(FormMode.VIEW);
		boolean allowEditPatientAssessment = false;//viewMode && isPatientUserDefinedObjectSelected(form.dyngrdAssessments().getSelectedRow());
		boolean allowEditPatientAssessmentData = viewMode && isPatientAssessmentDataSelected();
		boolean allowViewGraphic = allowEditPatientAssessmentData && isDataAdded() && isGraphicAssessmentData();
		boolean allowEditGraphic = allowViewGraphic && isNotCompleted();
		boolean allowAddGraphic  = allowEditPatientAssessmentData && !isDataAdded() && isGraphicAssessmentData();
		boolean allowViewUserAssessment = allowEditPatientAssessmentData && isDataAdded() && isUserAssessmentData();
		boolean allowEditUserAssessment =  allowViewUserAssessment && isNotCompleted();
		boolean allowAddUserAssessment = allowEditPatientAssessmentData && !isDataAdded() && isUserAssessmentData();
		
		form.getContextMenus().getPatientAssessmentAddItem().setVisible(viewMode);
		form.getContextMenus().getPatientAssessmentUpdateItem().setVisible(allowEditPatientAssessment);

		String childName = getChildName(getSelectedPatientAssessmentData());
		if(childName != null)
		{
			String newLabel  = "New '"  + childName + "'";
			String editLabel = "Edit '" + childName + "'";
			String viewLabel = "View '" + childName + "'";
			
			form.getContextMenus().getPatientAssessmentAddGraphicAssessmentItem().setText(newLabel);
			form.getContextMenus().getPatientAssessmentUpdateGraphicAssessmentItem().setText(editLabel);
			form.getContextMenus().getPatientAssessmentViewGraphicAssessmentItem().setText(viewLabel);

			form.getContextMenus().getPatientAssessmentAddUserAssessmentItem().setText(newLabel);
			form.getContextMenus().getPatientAssessmentUpdateUserAssessmentItem().setText(editLabel);
			form.getContextMenus().getPatientAssessmentViewUserAssessmentItem().setText(viewLabel);
		}
		
		form.getContextMenus().getPatientAssessmentAddGraphicAssessmentItem().setVisible(allowAddGraphic);
		form.getContextMenus().getPatientAssessmentUpdateGraphicAssessmentItem().setVisible(allowEditGraphic);
		form.getContextMenus().getPatientAssessmentViewGraphicAssessmentItem().setVisible(allowViewGraphic);

		form.getContextMenus().getPatientAssessmentAddUserAssessmentItem().setVisible(allowAddUserAssessment);
		form.getContextMenus().getPatientAssessmentUpdateUserAssessmentItem().setVisible(allowEditUserAssessment);
		form.getContextMenus().getPatientAssessmentViewUserAssessmentItem().setVisible(allowViewUserAssessment);
	}

	private PatientAssessmentListVo getSelectedPatientAssessment(DynamicGridRow row)
	{
		if(row == null)
			return null;
		
		Object value = row.getValue(); 
		if(value instanceof PatientAssessmentListVo)
			return (PatientAssessmentListVo)value;
			 	
		return null;
	}
	
/*	private boolean isPatientUserDefinedObjectSelected(DynamicGridRow row)
	{
		if(row == null)
			return false;
		
		Object value = row.getValue(); 
		if(value instanceof PatientUserDefinedObjectListVo)
			return true;
			 	
		return false;
	}*/
	
	boolean isPatientAssessmentDataSelected()
	{
		DynamicGridRow row = form.dyngrdAssessments().getSelectedRow();

		if(row == null)
			return false;
		
		if(getSelectedPatientAssessment(row) != null)
			return true;
		
		return false;
	}
	private boolean isDataAdded()
	{
		PatientAssessmentListVo voPatientAssessmentList = getSelectedPatientAssessment(form.dyngrdAssessments().getSelectedRow());
		return voPatientAssessmentList != null && voPatientAssessmentList.getAssessmentDataIsNotNull() && 
			   (voPatientAssessmentList.getAssessmentData().getGraphicIsNotNull() || voPatientAssessmentList.getAssessmentData().getUserAssessmentIsNotNull()) &&  
			   voPatientAssessmentList.getAuthoringInformationIsNotNull();
	}
	private boolean isGraphicAssessmentData()
	{
		PatientAssessmentDataListVo voPatientAssessmentData = getSelectedPatientAssessmentData();
		return voPatientAssessmentData != null && voPatientAssessmentData.getGraphicIsNotNull(); 
	}
	
	private boolean isNotCompleted()
	{
		PatientAssessmentListVo voPatientAssessmentList = getSelectedPatientAssessment(form.dyngrdAssessments().getSelectedRow());
		return voPatientAssessmentList != null &&
		(voPatientAssessmentList.getStatus() == null || !voPatientAssessmentList.getStatus().equals(PatientAssessmentStatusReason.COMPLETED)); 
	}
	private boolean isUserAssessmentData()
	{
		PatientAssessmentDataListVo voPatientAssessmentData = getSelectedPatientAssessmentData();
		return voPatientAssessmentData != null && voPatientAssessmentData.getUserAssessmentIsNotNull(); 
	}
	
	private PatientAssessmentDataListVo getSelectedPatientAssessmentData()
	{
		DynamicGridRow row = form.dyngrdAssessments().getSelectedRow();
		if(row != null)
		{
			PatientAssessmentListVo voPatientAssessmentList = getSelectedPatientAssessment(row);
			if(voPatientAssessmentList != null)
			{
				return voPatientAssessmentList.getAssessmentData();
			}
		}
		
		return null;
	}
	
	private PatientAssessmentListVo getPatientAssessmentFromGrid()
	{
		DynamicGridRow row = form.dyngrdAssessments().getSelectedRow();
		if(row != null)
		{
			return getSelectedPatientAssessment(row);
		}
		
		return null;
	}
	
	private PatientUserDefinedObjectListVo getParentPatientUserDefinedObjectList()
	{
		DynamicGridRow row = form.dyngrdAssessments().getSelectedRow();
		if(row != null && row.getParent() != null)
		{
			Object value = row.getParent().getValue();
			if(value instanceof PatientUserDefinedObjectListVo)
				return (PatientUserDefinedObjectListVo)value;
		}
			
		return null;
	}
	
	private UserDefinedObjectComponentVo getEditedComponent(PatientUserDefinedObjectVo voPatientUserDefinedObject)
	{
		DynamicGridRow row = form.dyngrdAssessments().getSelectedRow();
		PatientAssessmentListVo voPatientAssessmentList = getSelectedPatientAssessment(row);
		return getAssessmentConfig().getEditedComponent(voPatientUserDefinedObject, voPatientAssessmentList);
	}

	private ims.assessment.helper.AssessmentConfig getAssessmentConfig()
	{
		return new ims.assessment.helper.AssessmentConfig();		
	}
	
	private void displayError(String error)
	{
		engine.showErrors(new String[]{error});
	}	
	//---- End Private methods -------------------
}