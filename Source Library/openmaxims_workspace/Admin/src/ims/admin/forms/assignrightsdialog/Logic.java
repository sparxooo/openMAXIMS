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
// This code was generated by Mara Iroaie using IMS Development Environment (version 1.80 build 5308.16958)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.admin.forms.assignrightsdialog;

import java.util.Arrays;
import java.util.Comparator;

import ims.admin.forms.assignrightsdialog.GenForm.grdRightsRow;
import ims.admin.vo.AppRightVo;
import ims.admin.vo.AppRightVoCollection;
import ims.configuration.AppRight;
import ims.framework.MessageButtons;
import ims.framework.MessageIcon;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;
	private static final String PDSSTRING = "PDS_"; //WDEV-20617

	@Override
	protected void onFormOpen(Object[] args) throws ims.framework.exceptions.PresentationLogicException
	{
		if ( args != null && args.length > 0 && args[0] instanceof Boolean )
			form.getLocalContext().setIsPdsRight((Boolean)args[0]);
		
		form.getLocalContext().setSelectedRights(null);
	}
	
	@Override
	protected void onImbClearClick() throws ims.framework.exceptions.PresentationLogicException
	{
		form.txtName().setValue(null);
		form.grdRights().getRows().clear();
	}
	
	@Override
	protected void onImbSearchClick() throws ims.framework.exceptions.PresentationLogicException
	{
		populateAppRightsGRid(form.txtName().getValue());	
	}
	
	private void populateAppRightsGRid(String value)
	{
		form.grdRights().getRows().clear(); 
		
		AppRight[] rights = AppRight.getAllRights();
		AppRightVo[] voRights = AppRightVo.domArrayToVo(rights);
		
		Arrays.sort(voRights, new  AppRightComparator());
				
		String roleRight = "";
		if (value != null && value.length() > 0)
			roleRight = value.replaceAll("%", "");
		
		for (int i = 0; i < voRights.length; i++)
		{
			AppRightVo voRight = voRights[i];	
			if(voRight != null && voRight.getNameIsNotNull() && (voRight.getName().toUpperCase().contains(roleRight.toUpperCase()) || roleRight.length() == 0))
			
			//WDEV-20617
			{	
				boolean bAddRow = form.getLocalContext().getIsPdsRight() && voRight.getName().substring(0,PDSSTRING.length()).toUpperCase().equals(PDSSTRING.toUpperCase()) 
									|| !form.getLocalContext().getIsPdsRight() && !voRight.getName().substring(0,PDSSTRING.length()).toUpperCase().equals(PDSSTRING.toUpperCase());
				if (bAddRow)
					newRow(voRight);
			}
			//WDEV-20617 ends here
		}
		
		if (form.grdRights().getRows().size() == 0)
			engine.showMessage("No records matching your search criteria were found!", "No results",MessageButtons.OK, MessageIcon.INFORMATION);
	}

	private void newRow(AppRightVo voRight)
	{	
		grdRightsRow row = form.grdRights().getRows().newRow();
		
		row.setAppRight(voRight.getName());
		row.setColSelect(isAlreadySelected(voRight) ? true : false);
		
		//WDEV-20577
		AppRight right = AppRight.getRight(voRight.getName());
		if (right != null)
			row.setTooltip(right.getComment()); //WDEV-20577
		
		row.setValue(voRight);		
	}
	
	private boolean isAlreadySelected(AppRightVo voRight) 
	{	
		//WDEV-20617
		AppRightVoCollection collSelectedRights;
		if (form.getLocalContext().getIsPdsRight())
			collSelectedRights = form.getGlobalContext().Admin.getSelectedPdsRoleRights();	
		else
			collSelectedRights = form.getGlobalContext().Admin.getSelectedRoleRigths();	
		//WDEV-20617 ends here
		
		if (collSelectedRights != null && collSelectedRights.size() > 0)
		{
    		for (int i = 0; i < collSelectedRights.size(); i++)
    		{
    			AppRightVo voSelectedRight = collSelectedRights.get(i);
    			if(voSelectedRight.getName().equals(voRight.getName()))
    				return true;
    		}
		}
		
		return false;
	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}
	
	@Override
	protected void onBtnSelectClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.OK);
	}
	
	class AppRightComparator implements Comparator<AppRightVo>
	{
		public int compare(AppRightVo arg0, AppRightVo arg1) {
			
			return getText(arg0).compareToIgnoreCase(getText(arg1));
		}
		
		private String getText(AppRightVo vo)
		{			
			if (vo == null || !vo.getNameIsNotNull())
				return "";
			return vo.getName();
		}		
	}

	@Override
	protected void onGrdRightsGridCheckBoxClicked(int column, grdRightsRow row, boolean isChecked) throws PresentationLogicException
	{
		//WDEV-20617
		AppRightVoCollection formSelectedRigrts;
		if (form.getLocalContext().getIsPdsRight())
			formSelectedRigrts = form.getGlobalContext().Admin.getSelectedPdsRoleRights();
		else
			formSelectedRigrts = form.getGlobalContext().Admin.getSelectedRoleRigths();
		//WDEV-20617 ends here
		
		if (formSelectedRigrts == null)
			formSelectedRigrts = new AppRightVoCollection();
		
		if (isChecked)
			formSelectedRigrts.add(row.getValue());
		else
			removeRightFromSelection(row.getValue());
		
		//WDEV-20617
		if (form.getLocalContext().getIsPdsRight())
			form.getGlobalContext().Admin.setSelectedPdsRoleRights(formSelectedRigrts);
		else
			form.getGlobalContext().Admin.setSelectedRoleRigths(formSelectedRigrts);
		//WDEV-20617 ends here
	}

	private void removeRightFromSelection(AppRightVo value)
	{
		//WDEV-20617
		AppRightVoCollection formSelectedRigrts;
		if (form.getLocalContext().getIsPdsRight())
			formSelectedRigrts = form.getGlobalContext().Admin.getSelectedPdsRoleRights();
		else
			formSelectedRigrts = form.getGlobalContext().Admin.getSelectedRoleRigths();
		//WDEV-20617 ends here
		
		if (formSelectedRigrts == null || formSelectedRigrts.size() < 1)
			return;
		
		for(int i=0; i<formSelectedRigrts.size(); i++)
		{
			if(formSelectedRigrts.get(i).getName() != null && value.getName() != null && formSelectedRigrts.get(i).getName().toUpperCase().equals(value.getName().toUpperCase()))
				formSelectedRigrts.remove(i);
		}
		
	}
}