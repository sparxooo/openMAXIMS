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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5589.25814)
// Copyright (C) 1995-2015 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.naes.forms.actiondialog;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		Naes = new NaesContext(context);
	}
	public final class NaesContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private NaesContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getActionDetailsIsNotNull()
		{
			return !cx_NaesActionDetails.getValueIsNull(context);
		}
		public ims.naes.vo.ActionDetailVo getActionDetails()
		{
			return (ims.naes.vo.ActionDetailVo)cx_NaesActionDetails.getValue(context);
		}
		public void setActionDetails(ims.naes.vo.ActionDetailVo value)
		{
			cx_NaesActionDetails.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_NaesActionDetails = new ims.framework.ContextVariable("Naes.ActionDetails", "_cv_Naes.ActionDetails");

		private ims.framework.Context context;
	}
	public boolean getActionPlanIsNotNull()
	{
		return !cx_ActionPlan.getValueIsNull(context);
	}
	public ims.core.vo.ActionPlanVo getActionPlan()
	{
		return (ims.core.vo.ActionPlanVo)cx_ActionPlan.getValue(context);
	}
		public void setActionPlan(ims.core.vo.ActionPlanVo value)
		{
		cx_ActionPlan.setValue(context, value);
		}

	private ims.framework.ContextVariable cx_ActionPlan = new ims.framework.ContextVariable("ActionPlan", "_cv_ActionPlan");

	public NaesContext Naes;
}