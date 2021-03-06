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

package ims.emergency.forms.postdischargeliaison;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.emergency.domain.PostDischargeLiaison.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.emergency.domain.PostDischargeLiaison domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void bindchklistLetterReviewStatusLookup()
	{
		this.form.chklistLetterReviewStatus().clear();
		ims.emergency.vo.lookups.LetterReviewStatusCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getLetterReviewStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.chklistLetterReviewStatus().newRow(lookupCollection.get(x));
		}
	}
	protected final void oncmbReasonForContactValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbReasonForContact().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReasonForContact existingInstance = (ims.emergency.vo.lookups.ReasonForContact)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbReasonForContactLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.ReasonForContact)
		{
			ims.emergency.vo.lookups.ReasonForContact instance = (ims.emergency.vo.lookups.ReasonForContact)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbReasonForContactLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.ReasonForContact existingInstance = (ims.emergency.vo.lookups.ReasonForContact)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbReasonForContact().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbReasonForContactLookup()
	{
		this.form.cmbReasonForContact().clear();
		ims.emergency.vo.lookups.ReasonForContactCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getReasonForContact(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbReasonForContact().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbReasonForContactLookupValue(int id)
	{
		ims.emergency.vo.lookups.ReasonForContact instance = ims.emergency.vo.lookups.LookupHelper.getReasonForContactInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbReasonForContact().setValue(instance);
	}
	protected final void defaultcmbReasonForContactLookupValue()
	{
		this.form.cmbReasonForContact().setValue((ims.emergency.vo.lookups.ReasonForContact)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.ReasonForContact.class, engine.getFormName().getID(), ims.emergency.vo.lookups.ReasonForContact.TYPE_ID));
	}
	protected final void oncmbContactMethodValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbContactMethod().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ContactMethod existingInstance = (ims.core.vo.lookups.ContactMethod)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbContactMethodLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.ContactMethod)
		{
			ims.core.vo.lookups.ContactMethod instance = (ims.core.vo.lookups.ContactMethod)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbContactMethodLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.ContactMethod existingInstance = (ims.core.vo.lookups.ContactMethod)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbContactMethod().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbContactMethodLookup()
	{
		this.form.cmbContactMethod().clear();
		ims.core.vo.lookups.ContactMethodCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getContactMethod(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbContactMethod().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbContactMethodLookupValue(int id)
	{
		ims.core.vo.lookups.ContactMethod instance = ims.core.vo.lookups.LookupHelper.getContactMethodInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbContactMethod().setValue(instance);
	}
	protected final void defaultcmbContactMethodLookupValue()
	{
		this.form.cmbContactMethod().setValue((ims.core.vo.lookups.ContactMethod)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.ContactMethod.class, engine.getFormName().getID(), ims.core.vo.lookups.ContactMethod.TYPE_ID));
	}
	protected final void oncmbPersonContactedValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbPersonContacted().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.PersonContacted existingInstance = (ims.emergency.vo.lookups.PersonContacted)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbPersonContactedLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.emergency.vo.lookups.PersonContacted)
		{
			ims.emergency.vo.lookups.PersonContacted instance = (ims.emergency.vo.lookups.PersonContacted)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbPersonContactedLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.emergency.vo.lookups.PersonContacted existingInstance = (ims.emergency.vo.lookups.PersonContacted)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbPersonContacted().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbPersonContactedLookup()
	{
		this.form.cmbPersonContacted().clear();
		ims.emergency.vo.lookups.PersonContactedCollection lookupCollection = ims.emergency.vo.lookups.LookupHelper.getPersonContacted(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbPersonContacted().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbPersonContactedLookupValue(int id)
	{
		ims.emergency.vo.lookups.PersonContacted instance = ims.emergency.vo.lookups.LookupHelper.getPersonContactedInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbPersonContacted().setValue(instance);
	}
	protected final void defaultcmbPersonContactedLookupValue()
	{
		this.form.cmbPersonContacted().setValue((ims.emergency.vo.lookups.PersonContacted)domain.getLookupService().getDefaultInstance(ims.emergency.vo.lookups.PersonContacted.class, engine.getFormName().getID(), ims.emergency.vo.lookups.PersonContacted.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.emergency.domain.PostDischargeLiaison domain;
}
