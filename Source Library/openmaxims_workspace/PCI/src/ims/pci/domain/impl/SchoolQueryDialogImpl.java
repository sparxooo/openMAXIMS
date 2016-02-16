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
// This code was generated by Cristian Belciug using IMS Development Environment (version 1.71 build 3594.20535)
// Copyright (C) 1995-2009 IMS MAXIMS. All rights reserved.

package ims.pci.domain.impl;

import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.SchoolShortVoAssembler;
import ims.core.vo.lookups.LocationType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.pci.domain.base.impl.BaseSchoolQueryDialogImpl;

import java.util.ArrayList;

public class SchoolQueryDialogImpl extends BaseSchoolQueryDialogImpl
{

	private static final long serialVersionUID = 1L;

	/**
	 * WDEV - 12502 (entire function)
	 * Searching for schools will only list active records
	 */
	public ims.core.vo.SchoolShortVoCollection list(String school, ims.core.vo.LocationLiteVo sector)
	{
		DomainFactory factory = getDomainFactory();
		
		StringBuffer hql = new StringBuffer();
		hql.append("from School s where s.isActive = 1");
		
		ArrayList<String> markers = new ArrayList<String>();
		ArrayList<Object> values = new ArrayList<Object>();
		
		
		if(school != null)
		{
			hql.append(" and ");
			hql.append("s.upperCaseName like :schoolName");
			markers.add("schoolName");
			values.add(school.toUpperCase() + "%");					// WDEV-10956 - will only search for schools name beginning with text provided
		}
		
		if(sector != null && sector.getID_LocationIsNotNull())
		{
			hql.append(" and ");
			hql.append("s.sector.id = :sector");
			markers.add("sector");
			values.add(sector.getID_Location());
		}
		
		return SchoolShortVoAssembler.createSchoolShortVoCollectionFromSchool(factory.find(hql.toString(), markers, values));
	}

	public ims.core.vo.LocationLiteVoCollection listSectors(String sector)
	{
		if(sector == null || (sector != null && sector.trim().length() == 0))
			throw new DomainRuntimeException("String for search is null.");
		
		String sectorLite = sector != null ? sector.toUpperCase() + "%" : "%%";
		
		StringBuffer hql = new StringBuffer();
		hql.append(" from Location loc");
		hql.append(" where loc.upperName like :secName and loc.type.id = :typeValue");
		
		return LocationLiteVoAssembler.createLocationLiteVoCollectionFromLocation(getDomainFactory().find(hql.toString(), new String []{"secName", "typeValue"}, new Object []{sectorLite, LocationType.SECTOR.getID()}));
	}
}