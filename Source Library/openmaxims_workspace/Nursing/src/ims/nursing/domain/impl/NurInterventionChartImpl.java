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
// This code was generated by Neil McAnaspie using IMS Development Environment (version 1.22 build 41210.1630)
// Copyright (C) 1995-2004 IMS MAXIMS plc. All rights reserved.

package ims.nursing.domain.impl;

import java.util.ArrayList;
import ims.core.admin.vo.CareContextRefVo;
import ims.core.vo.ClinicalContactShortVo;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.impl.DomainImpl;
import ims.framework.exceptions.CodingRuntimeException;
import ims.nursing.domain.objects.InterventionChart;
import ims.nursing.vo.InterventionChartHeaderVoCollection;
import ims.nursing.vo.domain.InterventionChartHeaderVoAssembler;
import ims.nursing.vo.domain.InterventionChartVoAssembler;

public class NurInterventionChartImpl extends DomainImpl implements ims.nursing.domain.NurInterventionChart, ims.domain.impl.Transactional
{
	public ims.nursing.vo.InterventionChartVo getInterventionRecord(ims.nursing.vo.InterventionChartHeaderVo intervention)
	{
		DomainFactory factory = getDomainFactory();
		ims.nursing.domain.objects.InterventionChart interventionChart = (InterventionChart)factory.getDomainObject(InterventionChart.class, intervention.getID_InterventionChart());	
		return (InterventionChartVoAssembler.create(interventionChart));
	}					

	public ims.nursing.vo.InterventionChartHeaderVo saveIntervention(ims.nursing.vo.InterventionChartVo interventionChart, ClinicalContactShortVo contact) throws ims.domain.exceptions.StaleObjectException
	{
		if (!interventionChart.isValidated())
			throw new DomainRuntimeException("This Intervention Chart has not been validated");
		
		DomainFactory factory = getDomainFactory();
			
		InterventionChart doInterventionChart = InterventionChartVoAssembler.extractInterventionChart(factory, interventionChart);
		
		factory.save(doInterventionChart);	
			
		return InterventionChartHeaderVoAssembler.create(doInterventionChart);
		
	}
	/**
	* List Intervention Header Records
	*/
	public InterventionChartHeaderVoCollection listInterventionHeaderRecords(CareContextRefVo voCareContext) throws DomainInterfaceException
	{
		if(voCareContext == null)
			throw new CodingRuntimeException("Care Context not provided");
		
		DomainFactory factory = getDomainFactory();
		
		String hql = " from InterventionChart interventionChart "; 
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
	
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		
		if(voCareContext != null && voCareContext.getID_CareContextIsNotNull())
		{
			condStr.append(andStr + " interventionChart.careContext.id = :rcc"); 
			markers.add("rcc");
			values.add(voCareContext.getID_CareContext());
			andStr = " and ";
		}	
		
		if (andStr.equals(" and "))
			hql += " where ";
	
		hql += condStr.toString();
		return InterventionChartHeaderVoAssembler.createInterventionChartHeaderVoCollectionFromInterventionChart(factory.find(hql, markers, values));
	}
}