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

package ims.nursing.forms.planofcareactions;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.nursing.domain.PlanOfCareActions.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.nursing.domain.PlanOfCareActions domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbIntervalValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.lyr1().tabChronological().cmbInterval().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PlanOfCareInterval existingInstance = (ims.nursing.vo.lookups.PlanOfCareInterval)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbIntervalLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.nursing.vo.lookups.PlanOfCareInterval)
		{
			ims.nursing.vo.lookups.PlanOfCareInterval instance = (ims.nursing.vo.lookups.PlanOfCareInterval)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbIntervalLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.nursing.vo.lookups.PlanOfCareInterval existingInstance = (ims.nursing.vo.lookups.PlanOfCareInterval)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.lyr1().tabChronological().cmbInterval().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbIntervalLookup()
	{
		this.form.lyr1().tabChronological().cmbInterval().clear();
		ims.nursing.vo.lookups.PlanOfCareIntervalCollection lookupCollection = ims.nursing.vo.lookups.LookupHelper.getPlanOfCareInterval(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.lyr1().tabChronological().cmbInterval().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbIntervalLookupValue(int id)
	{
		ims.nursing.vo.lookups.PlanOfCareInterval instance = ims.nursing.vo.lookups.LookupHelper.getPlanOfCareIntervalInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.lyr1().tabChronological().cmbInterval().setValue(instance);
	}
	protected final void defaultcmbIntervalLookupValue()
	{
		this.form.lyr1().tabChronological().cmbInterval().setValue((ims.nursing.vo.lookups.PlanOfCareInterval)domain.getLookupService().getDefaultInstance(ims.nursing.vo.lookups.PlanOfCareInterval.class, engine.getFormName().getID(), ims.nursing.vo.lookups.PlanOfCareInterval.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.nursing.domain.PlanOfCareActions domain;
}
