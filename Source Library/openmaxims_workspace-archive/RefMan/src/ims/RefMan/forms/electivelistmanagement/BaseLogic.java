// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.RefMan.forms.electivelistmanagement;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.RefMan.domain.ElectiveListManagement.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.RefMan.domain.ElectiveListManagement domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected final void oncmbStatusValueSet(Object value)
	{
		java.util.ArrayList listOfValues = this.form.cmbStatus().getValues();

		if(value == null)
		{
			if(listOfValues != null && listOfValues.size() > 0)
			{
				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WaitingListStatus existingInstance = (ims.core.vo.lookups.WaitingListStatus)listOfValues.get(x);
					if(!existingInstance.isActive())
					{
						bindcmbStatusLookup();
						return;
					}
				}
			}
		}
		else if(value instanceof ims.core.vo.lookups.WaitingListStatus)
		{
			ims.core.vo.lookups.WaitingListStatus instance = (ims.core.vo.lookups.WaitingListStatus)value;

			if(listOfValues != null)
			{
				if(listOfValues.size() == 0)
					bindcmbStatusLookup();

				for(int x = 0; x < listOfValues.size(); x++)
				{
					ims.core.vo.lookups.WaitingListStatus existingInstance = (ims.core.vo.lookups.WaitingListStatus)listOfValues.get(x);
					if(existingInstance.equals(instance))
						return;
				}
			}

			this.form.cmbStatus().newRow(instance, instance.getText(), instance.getImage(), instance.getTextColor());
		}
	}
	protected final void bindcmbStatusLookup()
	{
		this.form.cmbStatus().clear();
		ims.core.vo.lookups.WaitingListStatusCollection lookupCollection = ims.core.vo.lookups.LookupHelper.getWaitingListStatus(this.domain.getLookupService());
		for(int x = 0; x < lookupCollection.size(); x++)
		{
			this.form.cmbStatus().newRow(lookupCollection.get(x), lookupCollection.get(x).getText(), lookupCollection.get(x).getImage(), lookupCollection.get(x).getTextColor());
		}
	}
	protected final void setcmbStatusLookupValue(int id)
	{
		ims.core.vo.lookups.WaitingListStatus instance = ims.core.vo.lookups.LookupHelper.getWaitingListStatusInstance(this.domain.getLookupService(), id);
		if(instance != null)
			this.form.cmbStatus().setValue(instance);
	}
	protected final void defaultcmbStatusLookupValue()
	{
		this.form.cmbStatus().setValue((ims.core.vo.lookups.WaitingListStatus)domain.getLookupService().getDefaultInstance(ims.core.vo.lookups.WaitingListStatus.class, engine.getFormName().getID(), ims.core.vo.lookups.WaitingListStatus.TYPE_ID));
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.RefMan.domain.ElectiveListManagement domain;
}
