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
// This code was generated by Peter Martin using IMS Development Environment (version 1.52 build 2508.29436)
// Copyright (C) 1995-2006 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import ims.clinical.domain.objects.PatientSECS;
import ims.clinical.vo.PatientSECSVo;
import ims.clinical.vo.domain.PatientSECSVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.StaleObjectException;
import ims.nursing.domain.base.impl.BaseSECSImpl;

public class SECSImpl extends BaseSECSImpl
{

	private static final long serialVersionUID = 1L;

	public PatientSECSVo savePatientSECS(PatientSECSVo patientSecs) throws StaleObjectException {
		if(!patientSecs.isValidated())
			throw new DomainRuntimeException("This MUST has not been validated");
		
		DomainFactory factory = getDomainFactory();
		PatientSECS doPatientSECS = PatientSECSVoAssembler.extractPatientSECS(factory, patientSecs);
		factory.save(doPatientSECS);
		return PatientSECSVoAssembler.create(doPatientSECS);
	}

}