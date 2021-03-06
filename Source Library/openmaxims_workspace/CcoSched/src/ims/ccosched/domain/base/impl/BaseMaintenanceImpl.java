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

package ims.ccosched.domain.base.impl;

import ims.dto.DTODomainImplementation;

public abstract class BaseMaintenanceImpl extends DTODomainImplementation implements ims.ccosched.domain.Maintenance, ims.domain.impl.Transactional
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	public void validategetPatient(ims.core.vo.PatientShort patient)
	{
	}

	@SuppressWarnings("unused")
	public void validategetPatient(String pkey)
	{
	}

	@SuppressWarnings("unused")
	public void validategetSd_appt(String appt_head_id)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistSd_appt_dts(String prfile_sess_id, String prfiled_sess_id, String appt_stat, String act_comp_flg)
	{
	}

	@SuppressWarnings("unused")
	public void validatelistClinicDetails(String prfile_id, String sess_dt)
	{
	}

	@SuppressWarnings("unused")
	public void validategetClinicDetails(String prfile_sess_id)
	{
	}

	@SuppressWarnings("unused")
	public void validategetLookupInstance(String lkup_type)
	{
	}

	@SuppressWarnings("unused")
	public void validategetForUpdate(ims.dto.client.Sd_appt sd_appt)
	{
	}

	@SuppressWarnings("unused")
	public void validateupdate(ims.dto.client.Sd_appt sd_appt)
	{
	}
}
