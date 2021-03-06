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
// This code was generated by Daniel Laffan using IMS Development Environment (version 1.20 build 40730.1000)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.core.forms.yesnodialog;

import ims.framework.delegates.CancelArgs;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

public class Logic extends BaseLogic
{
	private static final long	serialVersionUID	= 1L;

	protected void onFormOpen() throws ims.framework.exceptions.FormOpenException
	{
		if(form.getGlobalContext().Core.getYesNoDialogLaunchedFromSelf() == null || form.getGlobalContext().Core.getYesNoDialogLaunchedFromSelf().equals(Boolean.FALSE))
		{
			if(form.getGlobalContext().OCRR.SelectAndOrder.getLaunchYesNoGenderDialogIsNotNull() && form.getGlobalContext().OCRR.SelectAndOrder.getLaunchYesNoGenderDialog().equals(Boolean.TRUE) && form.getGlobalContext().OCRR.SelectAndOrder.getLaunchYesNoReOrderDialogIsNotNull() && form.getGlobalContext().OCRR.SelectAndOrder.getLaunchYesNoReOrderDialog().equals(Boolean.TRUE))
			{
				form.getGlobalContext().Core.setYesNoDialogLaunchedFromSelf(Boolean.TRUE);
				engine.open(form.getForms().Core.YesNoDialog);
			}
		}

		if (form.getGlobalContext().Core.getHideCancelButtonIsNotNull())
		{
			if(form.getGlobalContext().Core.getHideCancelButton().equals(Boolean.TRUE))
				form.btnCancel().setVisible(false);
		}
		else
			form.btnCancel().setVisible(true);

		form.imgQuestion().setValue(form.getImages().Core.Question);
		
		if(engine.getParentDialogFormName() != null && engine.getParentDialogFormName().equals(form.getForms().Core.YesNoDialog))
		{
			if(form.getGlobalContext().Core.getSecondYesNoDialogMessageIsNotNull())
				form.txtQuestion().setValue(form.getGlobalContext().Core.getSecondYesNoDialogMessage());
		}
		else
		{
			if(form.getGlobalContext().Core.getYesNoDialogMessageIsNotNull())
				form.txtQuestion().setValue(form.getGlobalContext().Core.getYesNoDialogMessage());
		}

		form.lblPass().setVisible(false);
		form.txtPass().setVisible(false);
		form.getGlobalContext().setPasswordEntered(null);
		if (engine.getPreviousNonDialogFormName().equals(form.getForms().Admin.ConfigFlags) ||
			engine.getPreviousNonDialogFormName().equals(form.getForms().Admin.LookupTree)	||
			engine.getPreviousNonDialogFormName().equals(form.getForms().Admin.DeployReports) ||
			engine.getPreviousNonDialogFormName().equals(form.getForms().Admin.TaxonomyCodeAdmin) ||
			engine.getPreviousNonDialogFormName().equals(form.getForms().Admin.ApplicationUsers) ||
			engine.getPreviousNonDialogFormName().equals(form.getForms().Admin.PatientSearchConfiguration))			
		{
			form.txtQuestion().setTextColor(Color.Red);
			form.btnNo().setVisible(false);
			form.btnYes().setText("OK");
			form.lblPass().setVisible(true);
			form.txtPass().setVisible(true);	
			form.txtPass().setFocus();
		}		
	}
	
	protected void onBtnYesClick() throws PresentationLogicException 
	{	
		if (form.txtPass().isVisible() && form.txtPass().getValue() == null)
		{
			engine.showMessage("Password cannot be blank");
			return;
		}
		form.getGlobalContext().setPasswordEntered(form.txtPass().getValue());
		engine.close(DialogResult.YES);
	}
	
	protected void onBtnNoClick() throws PresentationLogicException 
	{
		engine.close(DialogResult.NO);
	}

	
	protected void onBtnCancelClick() throws PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);		
	}

	protected void onFormClosing(CancelArgs args) throws PresentationLogicException 
	{
		form.getGlobalContext().Core.setYesNoDialogMessage(null);		
	}
}
