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

package ims.clinicaladmin.forms.tumourdetailsrecurrence;

import java.io.Serializable;

public final class GlobalContext extends ims.framework.FormContext implements Serializable
{
	private static final long serialVersionUID = 1L;

	public GlobalContext(ims.framework.Context context)
	{
		super(context);

		ClinicalAdmin = new ClinicalAdminContext(context);
		Core = new CoreContext(context);
	}
	public final class ClinicalAdminContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private ClinicalAdminContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getTumourDetailsRecurrenceIsNotNull()
		{
			return !cx_ClinicalAdminTumourDetailsRecurrence.getValueIsNull(context);
		}
		public ims.clinicaladmin.vo.PatientTumourRecurrenceVoCollection getTumourDetailsRecurrence()
		{
			return (ims.clinicaladmin.vo.PatientTumourRecurrenceVoCollection)cx_ClinicalAdminTumourDetailsRecurrence.getValue(context);
		}
		public void setTumourDetailsRecurrence(ims.clinicaladmin.vo.PatientTumourRecurrenceVoCollection value)
		{
			cx_ClinicalAdminTumourDetailsRecurrence.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_ClinicalAdminTumourDetailsRecurrence = new ims.framework.ContextVariable("ClinicalAdmin.TumourDetailsRecurrence", "_cv_ClinicalAdmin.TumourDetailsRecurrence");

		private ims.framework.Context context;
	}
	public final class CoreContext implements Serializable
	{
		private static final long serialVersionUID = 1L;

		private CoreContext(ims.framework.Context context)
		{
			this.context = context;

		}

		public boolean getParentFormModeIsNotNull()
		{
			return !cx_CoreParentFormMode.getValueIsNull(context);
		}
		public ims.framework.enumerations.FormMode getParentFormMode()
		{
			return (ims.framework.enumerations.FormMode)cx_CoreParentFormMode.getValue(context);
		}
		public void setParentFormMode(ims.framework.enumerations.FormMode value)
		{
			cx_CoreParentFormMode.setValue(context, value);
		}

		private ims.framework.ContextVariable cx_CoreParentFormMode = new ims.framework.ContextVariable("Core.ParentFormMode", "_cv_Core.ParentFormMode");

		private ims.framework.Context context;
	}

	public ClinicalAdminContext ClinicalAdmin;
	public CoreContext Core;
}
