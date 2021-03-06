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

package ims.RefMan.forms.surgicaloperationnotes;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.RefMan.domain.SurgicalOperationNotes.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.RefMan.domain.SurgicalOperationNotes domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbFollowUpInValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctn().cmbFollowUpIn().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.SurgicalOpFollowUpIn existingInstance = (ims.RefMan.vo.lookups.SurgicalOpFollowUpIn)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFollowUpInLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.RefMan.vo.lookups.SurgicalOpFollowUpIn)
		{
			ims.RefMan.vo.lookups.SurgicalOpFollowUpIn instance = (ims.RefMan.vo.lookups.SurgicalOpFollowUpIn)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbFollowUpInLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.SurgicalOpFollowUpIn existingInstance = (ims.RefMan.vo.lookups.SurgicalOpFollowUpIn)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctn().cmbFollowUpIn().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFollowUpInLookup()
	{
		this.form.ctn().cmbFollowUpIn().clear();
		ims.RefMan.vo.lookups.SurgicalOpFollowUpInCollection lookupCollection = ims.RefMan.vo.lookups.LookupHelper.getSurgicalOpFollowUpIn(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctn().cmbFollowUpIn().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFollowUpInLookupValue(int id)
	{
		ims.RefMan.vo.lookups.SurgicalOpFollowUpIn instance = ims.RefMan.vo.lookups.LookupHelper.getSurgicalOpFollowUpInInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctn().cmbFollowUpIn().setValue(instance);
	}
	protected final void defaultcmbFollowUpInLookupValue()
	{
		this.form.ctn().cmbFollowUpIn().setValue((ims.RefMan.vo.lookups.SurgicalOpFollowUpIn)domain.getLookupService().getDefaultInstance(ims.RefMan.vo.lookups.SurgicalOpFollowUpIn.class, engine.getFormName().getID(), ims.RefMan.vo.lookups.SurgicalOpFollowUpIn.TYPE_ID));
	}
	protected final void oncmbFollowUpValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.ctn().cmbFollowUp().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.SurgicalOpFollowUpType existingInstance = (ims.RefMan.vo.lookups.SurgicalOpFollowUpType)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbFollowUpLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.RefMan.vo.lookups.SurgicalOpFollowUpType)
		{
			ims.RefMan.vo.lookups.SurgicalOpFollowUpType instance = (ims.RefMan.vo.lookups.SurgicalOpFollowUpType)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbFollowUpLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.RefMan.vo.lookups.SurgicalOpFollowUpType existingInstance = (ims.RefMan.vo.lookups.SurgicalOpFollowUpType)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.ctn().cmbFollowUp().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbFollowUpLookup()
	{
		this.form.ctn().cmbFollowUp().clear();
		ims.RefMan.vo.lookups.SurgicalOpFollowUpTypeCollection lookupCollection = ims.RefMan.vo.lookups.LookupHelper.getSurgicalOpFollowUpType(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.ctn().cmbFollowUp().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbFollowUpLookupValue(int id)
	{
		ims.RefMan.vo.lookups.SurgicalOpFollowUpType instance = ims.RefMan.vo.lookups.LookupHelper.getSurgicalOpFollowUpTypeInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.ctn().cmbFollowUp().setValue(instance);
	}
	protected final void defaultcmbFollowUpLookupValue()
	{
		this.form.ctn().cmbFollowUp().setValue((ims.RefMan.vo.lookups.SurgicalOpFollowUpType)domain.getLookupService().getDefaultInstance(ims.RefMan.vo.lookups.SurgicalOpFollowUpType.class, engine.getFormName().getID(), ims.RefMan.vo.lookups.SurgicalOpFollowUpType.TYPE_ID));
	}
	public void initialize() throws ims.framework.exceptions.FormOpenException
	{
	}
	public boolean allowNew()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public boolean allowUpdate()
	{
		return form.getMode() == ims.framework.enumerations.FormMode.VIEW && !form.isReadOnly();
	}
	public String[] validateUIRules()
	{
		return null;
	}
	public void clear()
	{
	}
	public void search()
	{
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.RefMan.domain.SurgicalOperationNotes domain;
}
