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

package ims.RefMan.forms.dischargeoutcomeform;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.RefMan.domain.DischargeOutcomeForm.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.RefMan.domain.DischargeOutcomeForm domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbDischMethodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDischMethod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DischargeMethod existingInstance = (ims.core.vo.lookups.DischargeMethod)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDischMethodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.DischargeMethod)
		{
			ims.core.vo.lookups.DischargeMethod instance = (ims.core.vo.lookups.DischargeMethod)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDischMethodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.DischargeMethod existingInstance = (ims.core.vo.lookups.DischargeMethod)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDischMethod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDischMethodLookup()
	{
		this.form.cmbDischMethod().clear();
		ims.core.vo.lookups.DischargeMethodCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getDischargeMethod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDischMethod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDischMethodLookupValue(int id)
	{
		ims.core.vo.lookups.DischargeMethod instance = ims.core.vo.lookups.LookupHelper.getDischargeMethodInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDischMethod().setValue(instance);
	}
	protected final void defaultcmbDischMethodLookupValue()
	{
		this.form.cmbDischMethod().setValue((ims.core.vo.lookups.DischargeMethod)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.DischargeMethod.class, engine.getFormName().getID(), ims.core.vo.lookups.DischargeMethod.TYPE_ID));
	}
	protected final void oncmbFollowupTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbFollowupType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.FollowupManagementType existingInstance = (ims.RefMan.vo.lookups.FollowupManagementType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFollowupTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.RefMan.vo.lookups.FollowupManagementType)
		{
			ims.RefMan.vo.lookups.FollowupManagementType instance = (ims.RefMan.vo.lookups.FollowupManagementType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbFollowupTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.FollowupManagementType existingInstance = (ims.RefMan.vo.lookups.FollowupManagementType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbFollowupType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFollowupTypeLookup()
	{
		this.form.cmbFollowupType().clear();
		ims.RefMan.vo.lookups.FollowupManagementTypeCollection lookupCollection = ims.RefMan.vo.lookups.LookupHelper.getFollowupManagementType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbFollowupType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFollowupTypeLookupValue(int id)
	{
		ims.RefMan.vo.lookups.FollowupManagementType instance = ims.RefMan.vo.lookups.LookupHelper.getFollowupManagementTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbFollowupType().setValue(instance);
	}
	protected final void defaultcmbFollowupTypeLookupValue()
	{
		this.form.cmbFollowupType().setValue((ims.RefMan.vo.lookups.FollowupManagementType)domain.getLookupService().getDefaultInstance(ims.RefMan.vo.lookups.FollowupManagementType.class, engine.getFormName().getID(), ims.RefMan.vo.lookups.FollowupManagementType.TYPE_ID));
	}
	protected final void oncmbDischTypeValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbDischType().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.ConsultationOutcomeType existingInstance = (ims.RefMan.vo.lookups.ConsultationOutcomeType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbDischTypeLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.RefMan.vo.lookups.ConsultationOutcomeType)
		{
			ims.RefMan.vo.lookups.ConsultationOutcomeType instance = (ims.RefMan.vo.lookups.ConsultationOutcomeType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbDischTypeLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.ConsultationOutcomeType existingInstance = (ims.RefMan.vo.lookups.ConsultationOutcomeType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbDischType().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbDischTypeLookup()
	{
		this.form.cmbDischType().clear();
		ims.RefMan.vo.lookups.ConsultationOutcomeTypeCollection lookupCollection = ims.RefMan.vo.lookups.LookupHelper.getConsultationOutcomeType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbDischType().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbDischTypeLookupValue(int id)
	{
		ims.RefMan.vo.lookups.ConsultationOutcomeType instance = ims.RefMan.vo.lookups.LookupHelper.getConsultationOutcomeTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbDischType().setValue(instance);
	}
	protected final void defaultcmbDischTypeLookupValue()
	{
		this.form.cmbDischType().setValue((ims.RefMan.vo.lookups.ConsultationOutcomeType)domain.getLookupService().getDefaultInstance(ims.RefMan.vo.lookups.ConsultationOutcomeType.class, engine.getFormName().getID(), ims.RefMan.vo.lookups.ConsultationOutcomeType.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.RefMan.domain.DischargeOutcomeForm domain;
}
