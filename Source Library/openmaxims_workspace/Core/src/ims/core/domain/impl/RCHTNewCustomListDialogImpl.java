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
// This code was generated by Rory Fitzpatrick using IMS Development Environment (version 1.71 build 3691.28308)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.core.domain.impl;

import ims.core.domain.base.impl.BaseNewCustomListDialogImpl;
import ims.domain.DomainFactory;
import ims.framework.exceptions.CodingRuntimeException;

import java.util.ArrayList;
import java.util.List;

public class RCHTNewCustomListDialogImpl extends BaseNewCustomListDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* Check if a list of this name already exists
	*/
	public Boolean checkIfCustomListNameExists(String nameString)
	{
		if(nameString == null)
			throw new CodingRuntimeException("Mandatory parameter - Name not supplied");

		ArrayList names = new ArrayList();
		ArrayList values = new ArrayList();
		
		DomainFactory factory = getDomainFactory();
		StringBuffer hql = new StringBuffer("from CustomList cl ");
		hql.append(" where cl.listName = :lname");
		names.add("lname");
		values.add(nameString);
		
		hql.append (" and cl.isActive = :isActive");
		names.add("isActive");
		values.add(Boolean.TRUE);	

		List list = factory.find(hql.toString(), names,values);
		if (list.size() > 0 )
			return true;
		else
			return false;
	}
}