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
// This code was generated by Bogdan Tofei using IMS Development Environment (version 1.80 build 5256.13787)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.

package ims.clinical.forms.vtecolourconfig;

import ims.core.vo.VTEAssessmentColourConfigVo;
import ims.framework.enumerations.DialogResult;
import ims.framework.exceptions.PresentationLogicException;
import ims.framework.utils.Color;

import java.util.ArrayList;

public class Logic extends BaseLogic
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void onFormOpen(Object[] args) throws PresentationLogicException
	{

		clearScreen();
		populateColourCombo();

		VTEAssessmentColourConfigVo colourConfig = form.getGlobalContext().Clinical.getVTEColourConfig();

		if (colourConfig == null)
			return;

		form.intFromHours().setValue(colourConfig.getFromHours());
		form.intToHours().setValue(colourConfig.getToHours());
		form.cmbColour().setValue(colourConfig.getWorklistEntryColour());

	}

	private void clearScreen()
	{
		form.intFromHours().setValue(null);
		form.intToHours().setValue(null);
		form.cmbColour().clear();

	}

	private void populateColourCombo()
	{
		Color[] ca = Color.getAllColors();

		for (int i = 0; i < ca.length; i++)
		{
			form.cmbColour().newRow(ca[i], ca[i].getName(), ca[i].getImage());
		}

	}

	@Override
	protected void onBtnCancelClick() throws ims.framework.exceptions.PresentationLogicException
	{
		engine.close(DialogResult.CANCEL);
	}

	@Override
	protected void onBtnOKClick() throws ims.framework.exceptions.PresentationLogicException
	{
		VTEAssessmentColourConfigVo colourConfig = populateDataFromScreen(form.getGlobalContext().Clinical.getVTEColourConfig());

		String[] errors = colourConfig.validate(getUIErrors());
		if (errors != null && errors.length > 0)
		{
			engine.showErrors(errors);
			return;
		}

		form.getGlobalContext().Clinical.setVTEColourConfig(colourConfig);
		engine.close(DialogResult.OK);
	}

	private String[] getUIErrors()
	{
		ArrayList<String> uiErrors = new ArrayList<String>();

		if (form.intFromHours().getValue() != null && form.intToHours().getValue() != null && form.intFromHours().getValue().intValue() >= form.intToHours().getValue().intValue())
		{
			uiErrors.add("'From (hours)' should be less than 'To (hours)'");
		}

		String[] uiResults = new String[uiErrors.size()];
		uiErrors.toArray(uiResults);

		return uiResults;
	}

	private VTEAssessmentColourConfigVo populateDataFromScreen(VTEAssessmentColourConfigVo vteColourConfig)
	{
		if (vteColourConfig == null)
			vteColourConfig = new VTEAssessmentColourConfigVo();

		vteColourConfig.setFromHours(form.intFromHours().getValue());
		vteColourConfig.setToHours(form.intToHours().getValue());
		vteColourConfig.setWorklistEntryColour(form.cmbColour().getValue());

		return vteColourConfig;
	}

}
