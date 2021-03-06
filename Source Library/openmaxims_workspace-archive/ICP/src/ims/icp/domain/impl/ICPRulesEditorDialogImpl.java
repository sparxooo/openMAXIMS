//#############################################################################
//#                                                                           #
//#  Copyright (C) <2014>  <IMS MAXIMS>                                       #
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
//#############################################################################
//#EOH
// This code was generated by George Cristian Josan using IMS Development Environment (version 1.71 build 3749.21039)
// Copyright (C) 1995-2010 IMS MAXIMS. All rights reserved.

package ims.icp.domain.impl;

import ims.icp.domain.base.impl.BaseICPRulesEditorDialogImpl;
import ims.icp.vo.ICPConfigurationDisplayVo;
import ims.icp.vo.domain.ICPConfigurationDisplayVoAssembler;
import ims.icps.configuration.domain.objects.ICP;

public class ICPRulesEditorDialogImpl extends BaseICPRulesEditorDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	* save
	*/
	public ims.admin.vo.BusinessRuleVo save(ims.admin.vo.BusinessRuleVo rule) throws ims.domain.exceptions.StaleObjectException
	{
		// TODO: Add your code here and change the return value.
		return null;
	}

	public ims.icp.vo.ICPConfigurationDisplayVo getDisplayICP(ims.icps.configuration.vo.ICPRefVo icp)
	{
		if (icp == null || !icp.getID_ICPIsNotNull())
			return null;
		
		return ICPConfigurationDisplayVoAssembler.create((ICP) getDomainFactory().getDomainObject(ICP.class, icp.getID_ICP()));
	}
}
