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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.80 build 3999.26423)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.nursing.forms.clinicalnotesupdateactionsdialog;

import ims.core.vo.HcpLiteVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.StaleObjectException;
import ims.framework.controls.DynamicGridCell;
import ims.framework.controls.DynamicGridCellOptions;
import ims.framework.controls.DynamicGridColumn;
import ims.framework.controls.DynamicGridRow;
import ims.framework.enumerations.DialogResult;
import ims.framework.enumerations.DynamicCellType;
import ims.framework.utils.Color;
import ims.framework.utils.Date;
import ims.framework.utils.DateFormat;
import ims.nursing.vo.CarePlan;
import ims.nursing.vo.CarePlanCollection;
import ims.nursing.vo.CarePlanInterventions;
import ims.nursing.vo.CarePlanTitleCollection;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	public static final Integer		COLORDERNUMBER	= new Integer(0);
	public static final Integer		COLDESC			= new Integer(1);
	public static final Integer		COLADDINFO		= new Integer(-1);
	public static final Integer		COLCOMPLETED	= new Integer(-2);
	public static final Integer		COLWHENWHO		= new Integer(-3);

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		initializeDynamicGrid();
		initialise(args);
	}
	
	private void initialise(Object[] args) 
	{
		form.btnSave().setEnabled(false);

		if(args == null)
			return;
		
		if(args.length == 1)
		{
			if(args[0] instanceof CarePlanTitleCollection)
			{
				
				CarePlanTitleCollection voCPs = (CarePlanTitleCollection) args[0];
				form.getLocalContext().setCarePlansTitleCollection(voCPs);
				populateGrid(voCPs);
			}
		}
	}

	private void populateGrid(CarePlanTitleCollection voCPs)
	{
		form.dyngrdInterventions().getRows().clear();
		
		CarePlanCollection voCarePlans = null;
		
		if (voCPs != null && voCPs.size() > 0)
			voCarePlans = domain.listCarePlans(voCPs);
		
		for (int i = 0 ; voCarePlans != null && i < voCarePlans.size() ; i++)
		{
			voCarePlans.get(i).getInterventions().sort();
			
			for (int j = 0 ; voCarePlans.get(i).getInterventionsIsNotNull() && j < voCarePlans.get(i).getInterventions().size() ; j++)
			{
				CarePlanInterventions voInt = voCarePlans.get(i).getInterventions().get(j);
				
				DynamicGridRow row = form.dyngrdInterventions().getRows().newRow();
				//WDEV-16795 
				String removalInfo = "";
				if (voInt != null && Boolean.TRUE.equals(voInt.getIsRemoved()))
				{
					row.setReadOnly(true);
					row.setBackColor(Color.Gray);
					removalInfo = "<b>Care Plan Action Removed since: </b>" + voInt.getRemovedDate().toString(DateFormat.STANDARD);
				}
				
				DynamicGridCell cellOrdNum = row.getCells().newCell(getColumn(COLORDERNUMBER), DynamicCellType.STRING);
				cellOrdNum.setValue(voInt.getOrder().toString());
				//WDEV-16795
				cellOrdNum.setTooltip(voInt.getOrder().toString()+ (removalInfo.length() > 0 ? "<br/>" + removalInfo : ""));
				cellOrdNum.setReadOnly(Boolean.TRUE);

				DynamicGridCell cellDesc = row.getCells().newCell(getColumn(COLDESC), DynamicCellType.STRING);
				cellDesc.setValue(voInt.getDescription().toString());
				//WDEV-16795
				cellDesc.setTooltip(voInt.getDescriptionIsNotNull() ? voInt.getDescription().toString() + (removalInfo.length() > 0 ? "<br/>" + removalInfo : ""): "" + (removalInfo.length() > 0 ? "<br/>" + removalInfo : ""));
				cellDesc.setReadOnly(Boolean.TRUE);
				
				DynamicGridCell cellInfo = row.getCells().newCell(getColumn(COLADDINFO), DynamicCellType.STRING);
				cellInfo.setValue(voInt.getAdditionalInfo());
				//WDEV-16795 
				cellInfo.setTooltip(voInt.getAdditionalInfoIsNotNull() ? voInt.getAdditionalInfo() : "" + (removalInfo.length() > 0 ? "<br/>" + removalInfo : ""));
				cellInfo.setReadOnly(Boolean.TRUE);
				
				DynamicGridCell cellComp = row.getCells().newCell(getColumn(COLCOMPLETED), DynamicCellType.BOOL, DynamicGridCellOptions.EDITABLE_DATA_CELL);
				cellComp.setValue(voInt.getStopDateIsNotNull() ? Boolean.TRUE : Boolean.FALSE);
				cellComp.setReadOnly(voInt.getStopDateIsNotNull() && !voInt.getIsRemoved());//WDEV-16795
				cellComp.setAutoPostBack(Boolean.TRUE);
				
				DynamicGridCell cellCompInfo = row.getCells().newCell(getColumn(COLWHENWHO), DynamicCellType.STRING);
				cellCompInfo.setValue(voInt.getStopDateIsNotNull() || voInt.getStopByIsNotNull() ? 
						(voInt.getStopDateIsNotNull() ? voInt.getStopDate().toString() : "" ) + " " + (voInt.getStopByIsNotNull() ? voInt.getStopBy().getName().toString() : "" ) : "");
				//WDEV-16795 
				cellCompInfo.setTooltip(voInt.getStopDateIsNotNull() || voInt.getStopByIsNotNull() ? 
						(voInt.getStopDateIsNotNull() ? voInt.getStopDate().toString() + (removalInfo.length() > 0 ? "\n" + removalInfo : "") : "") + " " + (voInt.getStopByIsNotNull() ? voInt.getStopBy().getName().toString() + (removalInfo.length() > 0 ? "\n" + removalInfo : "") : "") : "" + (removalInfo.length() > 0 ? "\n" + removalInfo : ""));
				cellCompInfo.setReadOnly(Boolean.TRUE);
				
				row.setValue(voCarePlans.get(i));
				row.setIdentifier(voInt);
			}
		}
	}
	private DynamicGridColumn getColumn(Integer dynColIdentifier)
	{
		return form.dyngrdInterventions().getColumns().getByIdentifier(dynColIdentifier);
	}


	@Override
	protected void onBtnSaveClick() throws ims.framework.exceptions.PresentationLogicException
	{
		CarePlanCollection voCPColl = new CarePlanCollection();
		form.getLocalContext().setCarePlansToSave(voCPColl);
		
		for (int iRow = 0 ; iRow < form.dyngrdInterventions().getRows().size() ; iRow++)
		{
			DynamicGridCell cellComp = form.dyngrdInterventions().getRows().get(iRow).getCells().get(getColumn(COLCOMPLETED));
			if (cellComp != null 
				&& cellComp.getType() == DynamicCellType.BOOL
				&& (! cellComp.isReadOnly())
				&& ((Boolean) cellComp.getValue()) )
				addThisRowsCarePlanInterventionAndOtherInterventionstoo(form.dyngrdInterventions().getRows().get(iRow));
		}
		
		if (form.getLocalContext().getCarePlansToSave().size() > 0)
		{
			//validate Vo
			String[] arrErrors = form.getLocalContext().getCarePlansToSave().validate();
			if (arrErrors != null)
			{	
				engine.showErrors(arrErrors);
				return;
			}
			
			try
			{
				domain.saveCarePlans(form.getLocalContext().getCarePlansToSave());
			}
			catch(StaleObjectException e)
			{
				engine.showMessage(ims.configuration.gen.ConfigFlag.UI.STALE_OBJECT_MESSAGE.getValue());
				//WDEV-15239
				form.btnSave().setEnabled(false);
				populateGrid(form.getLocalContext().getCarePlansTitleCollection());
				return;
			} 
			catch (DomainInterfaceException e)
			{
				engine.showErrors(new String[]{e.getMessage()});
				return;
			}
		}
		engine.close(DialogResult.OK);
	}
	
	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	private void addThisRowsCarePlanInterventionAndOtherInterventionstoo(DynamicGridRow row) 
	{
		// Check to see if the CarePlan is already in collection
		for (int i = 0 ; i < form.getLocalContext().getCarePlansToSave().size() ; i++)
		{
			if (form.getLocalContext().getCarePlansToSave().get(i).getID_CarePlan().equals(((CarePlan)row.getValue()).getID_CarePlan()))
				return;
		}
		
		CarePlan voRowCarePlan = ((CarePlan)row.getValue());
		
		//Look thru grid find rows for suppplied CarePlan - voRowCarePlan
		for (int iRow = 0 ; iRow < form.dyngrdInterventions().getRows().size() ; iRow++)
		{
			if (((CarePlan)form.dyngrdInterventions().getRows().get(iRow).getValue()).getID_CarePlan().equals(voRowCarePlan.getID_CarePlan()))
			{
				CarePlanInterventions voRowIntervention = (CarePlanInterventions)form.dyngrdInterventions().getRows().get(iRow).getIdentifier();

				// see if associated Intervention - Row is ticked
				DynamicGridCell cellComp = form.dyngrdInterventions().getRows().get(iRow).getCells().get(getColumn(COLCOMPLETED));
				if (cellComp != null 
					&& cellComp.getType() == DynamicCellType.BOOL
					&& (! cellComp.isReadOnly())
					&& ((Boolean) cellComp.getValue()) )
				{
					//look for matching intervention in CarePlan - and set Stpooed INfo
					for( int iInter = 0 ; iInter < voRowCarePlan.getInterventions().size() ; iInter++)
					{
						if (voRowCarePlan.getInterventions().get(iInter).getID_CarePlanIntervention().equals(voRowIntervention.getID_CarePlanIntervention()))
						{
							voRowCarePlan.getInterventions().get(iInter).setStopBy((HcpLiteVo)domain.getHcpLiteUser());
							voRowCarePlan.getInterventions().get(iInter).setStopDate(new Date());
							//WDEV-12155 
							voRowCarePlan.getInterventions().get(iInter).setActive(false);
						}
					}
				}
			}
		}
		form.getLocalContext().getCarePlansToSave().add(voRowCarePlan);
	}

	private void initializeDynamicGrid() 
	{
		form.dyngrdInterventions().clear();
		form.dyngrdInterventions().setSelectable(true);
		
		DynamicGridColumn orderColumn = form.dyngrdInterventions().getColumns().newColumn("Order No.", COLORDERNUMBER);
		orderColumn.setWidth(70);	
		orderColumn.setReadOnly(true);
		
		DynamicGridColumn descColumn = form.dyngrdInterventions().getColumns().newColumn("Description", COLDESC);
		descColumn.setWidth(220);	
		orderColumn.setReadOnly(true);

		DynamicGridColumn infoColumn = form.dyngrdInterventions().getColumns().newColumn("Additional Information", COLADDINFO);
		infoColumn.setWidth(250);
		infoColumn.setReadOnly(true);
			
		DynamicGridColumn tickColumn = form.dyngrdInterventions().getColumns().newColumn("Completed", COLCOMPLETED);
		tickColumn.setWidth(70);
		
			
		DynamicGridColumn compColumn = form.dyngrdInterventions().getColumns().newColumn("Completion Information", COLWHENWHO);
		compColumn.setWidth(-1);
		compColumn.setReadOnly(true);
	}

	@Override
	protected void onDyngrdInterventionsCellButtonClicked(DynamicGridCell cell)
	{
		form.btnSave().setEnabled(false);
	}

	@Override
	protected void onDyngrdInterventionsCellValueChanged(DynamicGridCell cell) 
	{
		form.btnSave().setEnabled(true);
		
		// WDEV-12237 Complete data for cell if it is marked as true
		if (cell.getType() == DynamicCellType.BOOL && Boolean.TRUE.equals(cell.getValue()))
		{
			DynamicGridRow row = cell.getRow();
			
			// Get completing information cell
			DynamicGridCell completingInformationCell = row.getCells().get(getColumn(COLWHENWHO));
			
			// Set completing info
			StringBuilder displayText = new StringBuilder();
			
			displayText.append((new Date()).toString());
			displayText.append(" ");
			if (domain.getHcpLiteUser() != null)
				displayText.append(((HcpLiteVo)domain.getHcpLiteUser()).toString());
			
			completingInformationCell.setValue(displayText.toString());
			completingInformationCell.setTooltip(displayText.toString());
		}
		else
		{
			DynamicGridRow row = cell.getRow();
			DynamicGridCell completingInformationCell = row.getCells().get(getColumn(COLWHENWHO));
			
			completingInformationCell.setValue(null);
			completingInformationCell.setTooltip(null);
		}
		
	}

}