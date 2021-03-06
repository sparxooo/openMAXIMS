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

package ims.nursing.forms.transfer;

public abstract class BaseLogic extends Handlers
{
	public final Class getDomainInterface() throws ClassNotFoundException
	{
		return ims.nursing.domain.Transfer.class;
	}
	public final void setContext(ims.framework.UIEngine engine, GenForm form, ims.nursing.domain.Transfer domain)
	{
		setContext(engine, form);
		this.domain = domain;
	}
	protected void clearScreen()
	{
		this.form.timTransfer().setValue(null);
		this.form.dteTransfer().setValue(null);
		this.form.txtComments().setValue("");
	}
	protected void populateScreenFromData(ims.nursing.vo.TransferNote value)
	{
		clearScreen();
		if(value == null)
			return;

		if(value.getTransferDateIsNotNull())
			this.form.timTransfer().setValue(value.getTransferDate().getTime());
		else
			this.form.timTransfer().setValue(null);
		if(value.getTransferDateIsNotNull())
			this.form.dteTransfer().setValue(value.getTransferDate().getDate());
		else
			this.form.dteTransfer().setValue(null);
		this.form.txtComments().setValue(value.getTransferNoteIsNotNull() ? value.getTransferNote(): null);
	}
	protected ims.nursing.vo.TransferNote populateDataFromScreen(ims.nursing.vo.TransferNote value)
	{
		if(value == null)
			value = new ims.nursing.vo.TransferNote();

		if(value.getTransferDateIsNotNull())
			value.setTransferDate((value.getTransferDate().getDate() == null && this.form.timTransfer().getValue() == null) ? null : new ims.framework.utils.DateTime(value.getTransferDate().getDate(), this.form.timTransfer().getValue()));
		else
			value.setTransferDate(this.form.timTransfer().getValue() == null ? null : new ims.framework.utils.DateTime(null, this.form.timTransfer().getValue()));
		if(value.getTransferDateIsNotNull())
			value.setTransferDate((this.form.dteTransfer().getValue() == null && value.getTransferDate().getTime() == null) ? null : new ims.framework.utils.DateTime(this.form.dteTransfer().getValue(), value.getTransferDate().getTime()));
		else
			value.setTransferDate(this.form.dteTransfer().getValue() == null ? null : new ims.framework.utils.DateTime(this.form.dteTransfer().getValue(), null));
		value.setTransferNote(this.form.txtComments().getValue());

		return value;
	}
	protected ims.nursing.vo.TransferNote populateDataFromScreen()
	{
		return populateDataFromScreen(new ims.nursing.vo.TransferNote());
	}
	public final void free()
	{
		super.free();
		domain = null;
	}
	
	protected ims.nursing.domain.Transfer domain;
}
