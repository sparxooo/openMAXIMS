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
// This code was generated by Barbara Worwood using IMS Development Environment (version 1.80 build 5007.25751)
// Copyright (C) 1995-2014 IMS MAXIMS. All rights reserved.
// WARNING: DO NOT MODIFY the content of this file

package ims.admin.domain.base.impl;

import ims.domain.impl.DomainImpl;

public abstract class BaseHl7AdminImpl extends DomainImpl implements ims.admin.domain.Hl7Admin, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validatelistOrdersByDateTimeRange(ims.core.vo.PatientId patIdVo, ims.framework.utils.DateTime dtFrom, ims.framework.utils.DateTime dtTo)
	{
	}

	@SuppressWarnings("unused")
	public void validatesetInboundFlag(Boolean bStart)
	{
	}

	@SuppressWarnings("unused")
	public void validatesetOutboundFlag(Boolean bStart)
	{
	}

	@SuppressWarnings("unused")
	public void validategetOBFeedEntries(ims.framework.utils.DateTime startDate, ims.framework.utils.DateTime endDate, ims.core.vo.PatientId patientId, ims.core.vo.lookups.MsgEventType msgType, ims.core.admin.vo.ProviderSystemRefVo providerSystem)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveConfigFlag(ims.configuration.IFlag flag, String flagValue)
	{
	}

	@SuppressWarnings("unused")
	public void validatesaveOutBoundTriggers(ims.ocs_if.vo.OutboundTriggersVo outboundTriggers)
	{
	}

	@SuppressWarnings("unused")
	public void validatedeleteOutBoundTriggers(ims.ocs_if.vo.OutboundTriggersVo outBoundTriggers)
	{
	}
}
