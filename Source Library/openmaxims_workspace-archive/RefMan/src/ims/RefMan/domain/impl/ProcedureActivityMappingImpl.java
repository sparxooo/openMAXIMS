// This code was generated by Ander Telleria using IMS Development Environment (version 1.66 build 3257.22034)
// Copyright (C) 1995-2008 IMS MAXIMS plc. All rights reserved.

package ims.RefMan.domain.impl;

import java.util.List;
import java.util.Vector;

import ims.RefMan.domain.base.impl.BaseProcedureActivityMappingImpl;
import ims.RefMan.domain.objects.ProcedureActivityMapping;
import ims.RefMan.vo.ProcedureActivityMappingVo;
import ims.RefMan.vo.ProcedureActivityMappingVoCollection;
import ims.RefMan.vo.domain.ProcedureActivityMappingVoAssembler;
import ims.core.clinical.domain.objects.Procedure;
import ims.core.clinical.vo.ProcedureRefVo;
import ims.core.vo.ProcedureLiteVo;
import ims.core.vo.domain.ProcedureLiteVoAssembler;
import ims.domain.DomainFactory;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.hibernate3.IMSCriteria;

public class ProcedureActivityMappingImpl extends BaseProcedureActivityMappingImpl
{

	private static final long serialVersionUID = 1L;

	public ims.RefMan.vo.ProcedureActivityMappingVoCollection listProcedureActivies()
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(ProcedureActivityMapping.class,factory);
		List procedureActivities = imsc.find();
		if (procedureActivities!=null)
			return ProcedureActivityMappingVoAssembler.createProcedureActivityMappingVoCollectionFromProcedureActivityMapping(procedureActivities);
		return null;
	}

	public void saveProcedureActivity(ProcedureActivityMappingVo procAct) throws StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		factory.save(ProcedureActivityMappingVoAssembler.extractProcedureActivityMapping(factory, procAct));
	}

	public ProcedureLiteVo getProcedure(ProcedureRefVo procedureId) 
	{
		DomainFactory factory = getDomainFactory();
		IMSCriteria imsc=new IMSCriteria(Procedure.class,factory);
		imsc.equal("id", procedureId.getID_Procedure());
		List procedure = imsc.find();
		if (procedure!=null)
			return ProcedureLiteVoAssembler.create((Procedure) procedure.get(0));
		return null;
	}


	public ProcedureActivityMappingVoCollection saveProcedureActivities(ProcedureActivityMappingVoCollection procAct,ProcedureActivityMappingVoCollection activitiesToRemove)throws StaleObjectException 
	{
		DomainFactory factory = getDomainFactory();
		
		ProcedureActivityMappingVoCollection savedProcedures=new ProcedureActivityMappingVoCollection();
		if (procAct!=null)
		{
			for (int i=0;i<procAct.size();i++ )
			{
				ProcedureActivityMapping procedureActivity =ProcedureActivityMappingVoAssembler.extractProcedureActivityMapping(factory, procAct.get(i));
				factory.save(procedureActivity);
				savedProcedures.add(ProcedureActivityMappingVoAssembler.create(procedureActivity));
			}
			
			
		}
		if (activitiesToRemove!=null)
		{
			for (int i=0;i<activitiesToRemove.size();i++)
			{
				ProcedureActivityMapping procedureActivity =ProcedureActivityMappingVoAssembler.extractProcedureActivityMapping(factory, activitiesToRemove.get(i));
				try 
				{
					factory.delete(procedureActivity);
				} 
				catch (ForeignKeyViolationException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return savedProcedures;
	}
	
}
