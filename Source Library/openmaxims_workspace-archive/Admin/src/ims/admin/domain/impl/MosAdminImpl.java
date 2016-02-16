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
// This code was generated by Dara Hickey using IMS Development Environment (version 1.25 build 1941.15739)
// Copyright (C) 1995-2005 IMS MAXIMS plc. All rights reserved.

package ims.admin.domain.impl;

import ims.admin.domain.HcpAdmin;
import ims.admin.domain.MosSearch;
import ims.admin.domain.OrganisationAndLocation;
import ims.admin.helper.Keywords;
import ims.core.resource.domain.objects.HcpLocation;
import ims.core.resource.people.domain.objects.Hcp;
import ims.core.resource.people.domain.objects.Medic;
import ims.core.resource.people.domain.objects.MemberOfStaff;
import ims.core.resource.people.domain.objects.Nurse;
import ims.core.resource.people.domain.objects.Therapist;
import ims.core.resource.people.vo.HcpRefVo;
import ims.core.resource.people.vo.MedicRefVo;
import ims.core.resource.people.vo.MemberOfStaffRefVo;
import ims.core.resource.place.domain.objects.LocSite;
import ims.core.resource.place.domain.objects.Location;
import ims.core.resource.place.domain.objects.Organisation;
import ims.core.resource.place.vo.LocationRefVo;
import ims.core.vo.HCPLocationLiteVo;
import ims.core.vo.HCPLocationLiteVoCollection;
import ims.core.vo.HcpCollection;
import ims.core.vo.HcpFilter;
import ims.core.vo.HcpLiteVo;
import ims.core.vo.HcpLiteVoCollection;
import ims.core.vo.HcpMinVo;
import ims.core.vo.LocMostVoCollection;
import ims.core.vo.LocShortVoCollection;
import ims.core.vo.MedicLiteVoCollection;
import ims.core.vo.MedicVo;
import ims.core.vo.MedicVoCollection;
import ims.core.vo.MemberOfStaffLiteVo;
import ims.core.vo.MemberOfStaffLiteVoCollection;
import ims.core.vo.MemberOfStaffShortVo;
import ims.core.vo.MemberOfStaffShortVoCollection;
import ims.core.vo.MemberOfStaffVo;
import ims.core.vo.MemberOfStaffWithAppUserLiteVo;
import ims.core.vo.MosOrgLocVo;
import ims.core.vo.MosOrgLocVoCollection;
import ims.core.vo.NurseVo;
import ims.core.vo.OrgShortVo;
import ims.core.vo.OrgShortVoCollection;
import ims.core.vo.OrganisationVoCollection;
import ims.core.vo.TherapistVo;
import ims.core.vo.domain.CommChannelVoAssembler;
import ims.core.vo.domain.HCPLocationLiteVoAssembler;
import ims.core.vo.domain.HcpAssembler;
import ims.core.vo.domain.HcpLiteVoAssembler;
import ims.core.vo.domain.HcpMinVoAssembler;
import ims.core.vo.domain.LocShortVoAssembler;
import ims.core.vo.domain.LocSiteShortVoAssembler;
import ims.core.vo.domain.LocationLiteVoAssembler;
import ims.core.vo.domain.MedicLiteVoAssembler;
import ims.core.vo.domain.MedicVoAssembler;
import ims.core.vo.domain.MemberOfStaffLiteVoAssembler;
import ims.core.vo.domain.MemberOfStaffShortVoAssembler;
import ims.core.vo.domain.MemberOfStaffVoAssembler;
import ims.core.vo.domain.MemberOfStaffWithAppUserLiteVoAssembler;
import ims.core.vo.domain.NurseVoAssembler;
import ims.core.vo.domain.OrgShortVoAssembler;
import ims.core.vo.domain.TaxonomyMapAssembler;
import ims.core.vo.domain.TherapistVoAssembler;
import ims.core.vo.lookups.HcpDisType;
import ims.core.vo.lookups.MedicGrade;
import ims.core.vo.lookups.StaffType;
import ims.core.vo.lookups.TaxonomyType;
import ims.domain.DomainFactory;
import ims.domain.exceptions.DomainInterfaceException;
import ims.domain.exceptions.DomainRuntimeException;
import ims.domain.exceptions.ForeignKeyViolationException;
import ims.domain.exceptions.StaleObjectException;
import ims.domain.exceptions.UniqueKeyViolationException;
import ims.domain.exceptions.UnqViolationUncheckedException;
import ims.domain.impl.DomainImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class MosAdminImpl extends DomainImpl implements ims.admin.domain.MosAdmin, ims.domain.impl.Transactional
{
	private static final long	serialVersionUID	= 1L;

	public MemberOfStaffShortVoCollection listMembersOfStaff(MemberOfStaffShortVo filter)
	{
		MosSearch mosSearch = (MosSearch)getDomainImpl(MosSearchImpl.class);
		return mosSearch.listMembersOfStaff(filter);
	}
	

	public HcpCollection listHcps(HcpFilter filter)
	{
		if (filter.getQueryName() == null)
		{			
			MemberOfStaffShortVo voMos = new MemberOfStaffShortVo();
			voMos.setStaffType(StaffType.HCP);
			MemberOfStaffShortVoCollection coll = this.listMembersOfStaff(voMos);			
			HcpCollection voCollHcp = new HcpCollection();
			
			for (int i = 0; i < coll.size(); i++) 
			{
				MemberOfStaffShortVo voLocalMos = coll.get(i);
				voCollHcp.add(voLocalMos.getHcp());				
			}
			return voCollHcp;
		}
		else
		{
			HcpAdmin hcpAdmin = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
			return hcpAdmin.listHCPs(filter);
		}
	}

	public OrgShortVoCollection listOrganisationsShort(OrgShortVo filter)
	{
		OrganisationAndLocation orgLocImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return orgLocImpl.listOrganisationsShort(filter);
	}

	public LocMostVoCollection listLocSite(OrgShortVo filter)
	{
		OrganisationAndLocation orgLocImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return orgLocImpl.listLocSite(filter);
	}

	public OrganisationVoCollection listRootOrgs()
	{
		OrganisationAndLocation orgLocImpl = (OrganisationAndLocation) getDomainImpl(OrganisationAndLocationImpl.class);
		return orgLocImpl.listRootOrgs();
	}

	public MemberOfStaffShortVoCollection listMosForLocation(LocationRefVo voLocation)
	{
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();
		

		String hql = " from MemberOfStaff mos join fetch mos.locations loc where loc.location.id = :Location and mos.isActive = 1 order by mos.name.upperSurname,mos.name.upperForename"; //WDEV-15662
		if (voLocation != null)
		{
			markers.add("Location");
			values.add(voLocation.getID_Location());
		}

		DomainFactory factory = getDomainFactory();
		List mosList = factory.find(hql, markers, values);
		return MemberOfStaffShortVoAssembler.createMemberOfStaffShortVoCollectionFromMemberOfStaff(mosList);
	}

	public ims.core.vo.Hcp getHcp(HcpFilter filter)
	{
		HcpAdmin hcpAdminImpl = (HcpAdmin) getDomainImpl(HcpAdminImpl.class);
		return hcpAdminImpl.getHcp(filter);
	}

	public ims.core.vo.Hcp saveHcp(ims.core.vo.Hcp hcp) throws ims.domain.exceptions.StaleObjectException
	{
		if (!hcp.isValidated())
		{
			throw new DomainRuntimeException("HCP VO has not been validated.");
		}
		DomainFactory factory = getDomainFactory();

		hcp.getName().setUppers();
		Hcp doHcp = null;

		if (hcp instanceof MedicVo)
		{
			doHcp = MedicVoAssembler.extractMedic(factory, (MedicVo) hcp);
		}
		else if (hcp instanceof TherapistVo)
		{
			doHcp = TherapistVoAssembler.extractTherapist(factory, (TherapistVo) hcp);
		}
		else if (hcp instanceof NurseVo)
		{
			doHcp = NurseVoAssembler.extractNurse(factory, (NurseVo) hcp);
		}
		else
		{
			doHcp = HcpAssembler.extractHcp(factory, hcp);
		}

		factory.save(doHcp);
		hcp.setID_Hcp(doHcp.getId());
		return hcp;
	}

	public MosOrgLocVoCollection listOrganisationsForMos(MemberOfStaffRefVo mos)
	{
		DomainFactory factory = getDomainFactory();
		if (mos.getID_MemberOfStaff() == null)
		{
			return new MosOrgLocVoCollection();
		}
		
		MemberOfStaff mosBo = (MemberOfStaff)factory.getDomainObject(MemberOfStaff.class, mos.getID_MemberOfStaff());
		factory.refresh(mosBo);
		if (mosBo == null)
		{
			return new MosOrgLocVoCollection();
		}
		Set hcpLocations = mosBo.getLocations();
		return this.listOrganisationsForLocations(hcpLocations);
	}

	private MosOrgLocVoCollection listOrganisationsForLocations(Set hcpLocations)
	{
		HashMap orgs = new HashMap();

		Location doLocationThis = null;
		Iterator iter = hcpLocations.iterator();
		while (iter.hasNext())
		{
			HcpLocation hcpLoc = (HcpLocation)iter.next();
			doLocationThis = hcpLoc.getLocation();
			if (doLocationThis == null)
				continue;

			Location doLocationCurrent = doLocationThis;
			while (doLocationCurrent != null && !(doLocationCurrent instanceof LocSite))
				doLocationCurrent = doLocationCurrent.getParentLocation();

			if (doLocationCurrent == null)
				continue;
			
			Organisation doOrganisation = ((LocSite) doLocationCurrent).getParentOrganisation();
			if (doOrganisation!=null)
			{
			MosOrgLocVo voMosOrgLoc = (MosOrgLocVo) orgs.get(doOrganisation.getName());
			if (voMosOrgLoc == null)
			{
				voMosOrgLoc = new MosOrgLocVo();
				voMosOrgLoc.setOrganisation(OrgShortVoAssembler.create(doOrganisation));
				voMosOrgLoc.setHCPLocations(new HCPLocationLiteVoCollection());
			}

			if (hcpLoc.isIsPrimary() != null && hcpLoc.isIsPrimary().booleanValue())
			{
				voMosOrgLoc.setPrimaryLocation(LocationLiteVoAssembler.create(doLocationThis));
			}

			if (doLocationThis instanceof LocSite)
			{
				HCPLocationLiteVo voHCPLocLite = HCPLocationLiteVoAssembler.create(hcpLoc);
				
				voHCPLocLite.setLocation(LocSiteShortVoAssembler.create((LocSite) doLocationThis));
				voMosOrgLoc.getHCPLocations().add(voHCPLocLite);
			}
			else
			{
				HCPLocationLiteVo voHCPLocLite = HCPLocationLiteVoAssembler.create(hcpLoc);
				
				voHCPLocLite.setLocation(LocShortVoAssembler.create(doLocationThis));
				voMosOrgLoc.getHCPLocations().add(voHCPLocLite);
			}

			orgs.put(voMosOrgLoc.getOrganisation().getName(), voMosOrgLoc);
			}
		}

		MosOrgLocVoCollection voCollMosOrgLoc = new MosOrgLocVoCollection();

		iter = orgs.values().iterator();
		while (iter.hasNext())
			voCollMosOrgLoc.add((MosOrgLocVo) iter.next());

		return voCollMosOrgLoc.sort();
	}

	public MemberOfStaffVo saveMosVo(MemberOfStaffVo voMos) throws StaleObjectException, DomainInterfaceException, UniqueKeyViolationException
	{
		if (!voMos.isValidated())
			throw new DomainRuntimeException("Member of staff has not been validated");

		DomainFactory factory = getDomainFactory();
		Hcp doHcp = null;
		voMos.getName().setUppers();
		if (voMos.getHcpIsNotNull())
		{
			//Ensure the HCP is pointing back to the same MOS, ie the 1-1 bidirectional must be correct.
			voMos.getHcp().setMos(voMos);
			//WDEV-3653 added checks for getHcpTypeIsNotNull
			if (voMos.getHcp().getHcpTypeIsNotNull()&&voMos.getHcp().getHcpType().equals(HcpDisType.MEDICAL))
				doHcp = MedicVoAssembler.extractMedic(factory, (MedicVo) voMos.getHcp());
			else if (voMos.getHcp().getHcpTypeIsNotNull()&&voMos.getHcp().getHcpType().equals(HcpDisType.NURSING))
				doHcp = NurseVoAssembler.extractNurse(factory, (NurseVo) voMos.getHcp());
			else if (voMos.getHcp().getHcpTypeIsNotNull()&&voMos.getHcp().getHcpType().equals(HcpDisType.THERAPY))
				doHcp = TherapistVoAssembler.extractTherapist(factory, (TherapistVo) voMos.getHcp());
			else
				doHcp = HcpAssembler.extractHcp(factory, voMos.getHcp());
			//If we're adding a new MemberOfStaff, but the Associated hcp already exists
			if (null == voMos.getID_MemberOfStaff() && doHcp.getId() != null) 
			{
				throw new DomainInterfaceException("Hcp is already associated with another Member Of Staff");
			}

			if (null == doHcp.isIsActive() && doHcp.isIsActive() == null) // wdev-3819
				doHcp.setIsActive(Boolean.TRUE);
		}

		if (null == voMos.getID_MemberOfStaff() && !voMos.getIsActiveIsNotNull())  // wdev-3819 
			voMos.setIsActive(Boolean.TRUE);

		MemberOfStaff domMemberOfStaff = MemberOfStaffVoAssembler.extractMemberOfStaff(factory, voMos);
		domMemberOfStaff.setHcp(doHcp);
		
		
		domMemberOfStaff.getCodeMappings().clear();
		List mappings = TaxonomyMapAssembler.extractTaxonomyMapList(factory, voMos.getCodeMappings()); 
		domMemberOfStaff.setCodeMappings(mappings);
		
		
		
		domMemberOfStaff.getCommChannels().clear();
		List commChannels = CommChannelVoAssembler.extractCommunicationChannelList(factory,voMos.getCommChannels());
		domMemberOfStaff.setCommChannels(commChannels);
		
		try 
		{
			//clearMosTaxonomyMaps(voMos,factory);
			factory.save(domMemberOfStaff);
		}
		catch (UnqViolationUncheckedException e)
		{
			String dupMessage = Keywords.checkDuplicateTaxonomy(factory, domMemberOfStaff, "codeMappings", voMos.getCodeMappings(), "getName");
			if(dupMessage != null)
				throw new UniqueKeyViolationException(dupMessage);
			
			throw(e);
		}
		/*catch (ForeignKeyViolationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//JME: 20060814 : WDEV-1231
		this.clearMosAndHcp();
		
		return MemberOfStaffVoAssembler.create(domMemberOfStaff);

	}

	


	


	private void clearMosTaxonomyMaps(MemberOfStaffVo voMos, DomainFactory factory) throws ForeignKeyViolationException
	{
		factory.delete("from MemberOfStaff as mos left join mos.codeMappings as mappings where mos.id = " +voMos.getID_MemberOfStaff());	
	
	}


	


	public MemberOfStaffShortVo deactivateMos(MemberOfStaffShortVo mosVo) throws StaleObjectException
	{
		if (mosVo.getID_MemberOfStaff() == null)
		{
			throw new DomainRuntimeException("Cannot Activate/Deactivate an MOS with NULL id!");
		}
		DomainFactory factory = getDomainFactory();
		MemberOfStaff mosBo = MemberOfStaffShortVoAssembler.extractMemberOfStaff(getDomainFactory(), mosVo);
		mosBo.setIsActive(!(Boolean.TRUE.equals(mosBo.isIsActive())));
		
		if (mosBo.getHcp() != null)
		{
			mosBo.getHcp().setIsActive(mosBo.isIsActive());
		}
		
	
		factory.save(mosBo);
	
		return MemberOfStaffShortVoAssembler.create(mosBo);
	}

	public MemberOfStaffShortVo removeLinkedHcp(MemberOfStaffShortVo mosVo) throws StaleObjectException
	{
		if (mosVo.getID_MemberOfStaff() == null)
		{
			throw new DomainRuntimeException("Cannot remove a HCP from a MOS with NULL id!");
		}
		DomainFactory factory = getDomainFactory();
		MemberOfStaff mosBo = (MemberOfStaff) factory.getDomainObject(MemberOfStaff.class, mosVo.getID_MemberOfStaff());
		if (mosBo.getHcp() == null)
		{
			return mosVo;
		}

		mosBo.getHcp().setIsActive(Boolean.FALSE);
		factory.save(mosBo.getHcp());
		mosBo.setHcp(null);
		mosBo.setStaffType(null);
		factory.save(mosBo);
		mosVo.setHcp(null);
		return mosVo;
	}

	public MedicLiteVoCollection listConsultants()
	{
		DomainFactory factory = getDomainFactory();
		List lstMedics =  factory.find("from Medic m where m.isActive = :bActive and m.grade = :medicGrade", new String[]{"medicGrade", "bActive"}, new Object[]{getDomLookup(MedicGrade.CONS), Boolean.TRUE});
		return MedicLiteVoAssembler.createMedicLiteVoCollectionFromMedic(lstMedics);
	}

	public MemberOfStaffShortVoCollection listNCHDs()
	{
		DomainFactory factory = getDomainFactory();
		List lstMedics =  factory.find("from Medic m where m.isActive = :bActive and m.grade != :medicGrade", new String[]{"medicGrade", "bActive"}, new Object[]{getDomLookup(MedicGrade.CONS), Boolean.TRUE});

		MemberOfStaffShortVoCollection voCollMos = new MemberOfStaffShortVoCollection();
		for (Iterator iter = lstMedics.iterator(); iter.hasNext();)
		{
			MemberOfStaff doMos = ((Medic) iter.next()).getMos();
			voCollMos.add(MemberOfStaffShortVoAssembler.create(doMos));
		}
		return voCollMos;		
	}


	public MemberOfStaffShortVoCollection listMedics()
	{
		List lstMedics = listActiveMedics();
		return MemberOfStaffShortVoAssembler.createMemberOfStaffShortVoCollectionFromMemberOfStaff(lstMedics);
	}

	public MemberOfStaffShortVoCollection listMembersOfStaffWithPrimaryLocations(MemberOfStaffShortVo filter)
	{
		MosSearch mosSearch = (MosSearch)getDomainImpl(MosSearchImpl.class);
		return mosSearch.listMembersOfStaffWithPrimaryLocations(filter);

	}

	public LocShortVoCollection listLocationsForMemberOfStaff(MemberOfStaffRefVo mos)
	{
		LocShortVoCollection ret = new LocShortVoCollection();

		DomainFactory factory = getDomainFactory();
		if (mos.getID_MemberOfStaff() == null)
		{
			return ret;
		}		
		MemberOfStaff mosBo = (MemberOfStaff)factory.getDomainObject(MemberOfStaff.class, mos.getID_MemberOfStaff());
		if (mosBo == null)
		{
			return ret;
		}
		factory.refresh(mosBo);
		
		Location loc;
		HcpLocation hcpLoc;
		Set hcpLocations = mosBo.getLocations();
		Iterator iter = hcpLocations.iterator();
		while (iter.hasNext())
		{
			hcpLoc = (HcpLocation)iter.next();
			loc = hcpLoc.getLocation();
			if (loc == null)
				continue;

			ret.add(LocShortVoAssembler.create(loc));
		}
		return ret;
	}

	public MedicVoCollection listAllMedics()
	{
		MedicVoCollection voCollMedics = new MedicVoCollection();
		List lstMedics = listActiveMedics();
		if (lstMedics != null)
		{
			for (int i = 0; i < lstMedics.size(); i++)
			{
				Hcp hcp = (Hcp) lstMedics.get(i);
				if (Medic.class.isAssignableFrom(hcp.getClass()))
					voCollMedics.add(MedicVoAssembler.create((Medic) hcp));
			}
		}
		return voCollMedics;

	}

	public MemberOfStaffVo getMemberOfStaff(MemberOfStaffShortVo mos)
	{
		MemberOfStaffVo newMosVo = new MemberOfStaffVo();
		if (mos.getID_MemberOfStaff() == null)
		{
			MemberOfStaffShortVoAssembler.copy(newMosVo, mos);
			return newMosVo;
		}

		DomainFactory factory = getDomainFactory();
		MemberOfStaff mosDo = (MemberOfStaff)factory.getDomainObject(MemberOfStaff.class, mos.getID_MemberOfStaff().intValue());
		MemberOfStaffVo mosVo = MemberOfStaffVoAssembler.create(mosDo);
		if (mosVo.getHcpIsNotNull())
		{
			HcpFilter voFilter = new HcpFilter();
			voFilter.setID_Hcp(mosVo.getHcp().getID_Hcp());
			ims.core.vo.Hcp vohcp = getHcp(voFilter);
			mosVo.setHcp(vohcp);
		}
		return mosVo;
	}

	private MemberOfStaff getDomMosByTaxonomyType(String extId, TaxonomyType taxonomyType)
	{
		if (extId == null || taxonomyType == null)
			return null;

		DomainFactory factory = getDomainFactory();
		String hql = " from MemberOfStaff m " +
		" join m.codeMappings as cm" +
		" where cm.taxonomyName = :taxType " + 
		" and cm.taxonomyCode = :extId ";

		List mosList = factory.find(hql,new String[]{"taxType", "extId"}, new Object[]{getDomLookup(taxonomyType),extId});

		if (mosList == null || mosList.size() == 0)
		{
			return null;
		}
		else if (mosList.size() > 1)
		{
			throw new DomainRuntimeException("More than one MOS found with identifier type = " + taxonomyType.getText() + " and value = " + extId);
		}
		return (MemberOfStaff)mosList.get(0);
	}
	
	public MemberOfStaffLiteVo getMemberOfStaffLiteByTaxonomyType(String extId, TaxonomyType taxonomyType)
	{
		MemberOfStaff domMos = getDomMosByTaxonomyType(extId, taxonomyType);
		return MemberOfStaffLiteVoAssembler.create(domMos);
	}

	public MemberOfStaffVo getMemberOfStaffByTaxonomyType(String extId, TaxonomyType taxonomyType)
	{
		MemberOfStaff domMos = getDomMosByTaxonomyType(extId, taxonomyType);
		if (domMos == null)
			return null;
		
		MemberOfStaffVo mosVo = MemberOfStaffVoAssembler.create(domMos);
		ims.core.vo.Hcp hcp = null;
		if (domMos.getHcp() instanceof Medic)
		{
			hcp = MedicVoAssembler.create((Medic)domMos.getHcp());
		}
		else if (domMos.getHcp() instanceof Nurse)
		{
			hcp = NurseVoAssembler.create((Nurse)domMos.getHcp());
		}
		else if (domMos.getHcp() instanceof Therapist)
		{
			hcp = TherapistVoAssembler.create((Therapist)domMos.getHcp());
		}
		mosVo.setHcp(hcp);
		return mosVo;		
	}

	public MedicLiteVoCollection listMedicsLite() 
	{
		MedicLiteVoCollection voCollMedicsLite = new MedicLiteVoCollection();
		List lstMedics = listActiveMedics();
		if (lstMedics != null)
		{
			for (int i = 0; i < lstMedics.size(); i++)
			{
				Hcp hcp = (Hcp) lstMedics.get(i);
				if (Medic.class.isAssignableFrom(hcp.getClass()))
					voCollMedicsLite.add(MedicLiteVoAssembler.create((Medic) hcp));
			}
		}
		
		return voCollMedicsLite;
	}

	private List listActiveMedics() 
	{
		
		DomainFactory factory = getDomainFactory();
		return factory.find("from Hcp h where h.hcpType = :hcpType and h.isActive = :bActive", new String[]{"hcpType", "bActive"}, new Object[]{getDomLookup(HcpDisType.MEDICAL), Boolean.TRUE});
		
	}



	public MedicVoCollection listFullMedicsForMedicLites(MedicLiteVoCollection voCollLiteMedics) 
	{
		DomainFactory factory = getDomainFactory();
		StringBuffer hqlStart = new StringBuffer();
		String hql;

		hqlStart.append("from Hcp hcp where hcp.id in ( ");
		for (int i = 0; i < voCollLiteMedics.size(); i++)
			hqlStart.append(voCollLiteMedics.get(i) + ",");

		if (hqlStart.toString().endsWith(","))
			hql = hqlStart.toString().substring(0, hqlStart.length() - 1);
		else
			hql = hqlStart.toString();

		hql += " )";

		return MedicVoAssembler.createMedicVoCollectionFromMedic(factory.find(hql));
	}

	public HcpLiteVo getHcpLiteByTaxonomyType(String extCode, TaxonomyType taxType)
	{
		MemberOfStaff domMos = getDomMosByTaxonomyType(extCode, taxType);
		if (domMos == null)
			return null;
		else
		{
			return HcpLiteVoAssembler.create(domMos.getHcp());
		}
	}
	
	public HcpLiteVoCollection listHcpsLite(MemberOfStaffShortVo voFilter)
	{
		DomainFactory factory = getDomainFactory();
		String hql = " from Hcp h";
		StringBuffer condStr = new StringBuffer();
		String andStr = " ";
		ArrayList markers = new ArrayList();
		ArrayList values = new ArrayList();

		if (voFilter.getNameIsNotNull() && voFilter.getName().getSurname() != null && voFilter.getName().getSurname().length() > 0)
		{
			condStr.append(andStr + " h.mos.name.upperSurname like :mosSname");
			markers.add("mosSname");
			values.add(voFilter.getName().getSurname().toUpperCase() + "%");
			andStr = " and ";
		}
		if (voFilter.getStaffTypeIsNotNull())
		{
			condStr.append(andStr + " h.mos.staffType = :staffType");
			markers.add("staffType");
			values.add(getDomLookup(StaffType.HCP));
			andStr = " and ";
		}

		if (voFilter.getIsActiveIsNotNull() && voFilter.getIsActive().booleanValue())
		{
			condStr.append(andStr + " h.isActive = :isActive");
			markers.add("isActive");
			values.add(voFilter.getIsActive());
			andStr = " and ";
		}

		if (voFilter.getHcpIsNotNull() && voFilter.getHcp().getHcpTypeIsNotNull())
		{
			if (voFilter.getHcp().getHcpType().equals(HcpDisType.OTHER))
			{
				condStr.append(andStr + " h.hcpType not in (:hcpType1 , :hcpType2, :hcpType3)");
				markers.add("hcpType1");
				values.add(getDomLookup(HcpDisType.MEDICAL));
				markers.add("hcpType2");
				values.add(getDomLookup(HcpDisType.NURSING));
				markers.add("hcpType3");
				values.add(getDomLookup(HcpDisType.THERAPY));
				andStr = " and ";
			}
			else
			{
				condStr.append(andStr + " h.hcpType = :hcpType");
				markers.add("hcpType");
				values.add(getDomLookup(voFilter.getHcp().getHcpType()));
				andStr = " and ";
			}
		}

		if (andStr.equals(" and "))
			hql += " where ";

		hql += condStr.toString();
		List lstHCPs = factory.find(hql, markers, values);
		
		return HcpLiteVoAssembler.createHcpLiteVoCollectionFromHcp(lstHCPs);
	}

	public MemberOfStaffLiteVoCollection listActiveMosByName(String name)
	{
		MosSearch mosSearch = (MosSearch)getDomainImpl(MosSearchImpl.class);
		return mosSearch.listActiveMosByName(name);

	}


	public Boolean isCurrentMosMappedToUser(MemberOfStaffRefVo currentMos) throws DomainInterfaceException
	{
		if (!currentMos.getID_MemberOfStaffIsNotNull())
		{
			throw new DomainInterfaceException("Meber of Staff must have an valid ID");
		}
		String query = "from AppUser as a1_1 where " +
				"(a1_1.mos.id = :MemberOfStaff_id and a1_1.isActive = 1) )";
		int resultNr = getDomainFactory().count(query, new String[]{"MemberOfStaff_id"} , new Object[]{currentMos.getID_MemberOfStaff()});
		if (resultNr == 0)
			return Boolean.FALSE;
		return Boolean.TRUE;
	}

	//http://jira/browse/WDEV-13505
	public MedicRefVo getMedicRefByTaxonomyType(String extCode,TaxonomyType taxType)
	{
		MemberOfStaff domMos = getDomMosByTaxonomyType(extCode, taxType);
		if (domMos == null)
			return null;
		else
		{
			return new MedicRefVo(domMos.getHcp().getId(),domMos.getHcp().getVersion()); 
		}
	}


	//wdev-16588
	public MemberOfStaffWithAppUserLiteVo getMemberOffStaffWithAppUserById(MemberOfStaffRefVo memberOfStaffRefId)
	{
		DomainFactory factory = getDomainFactory();
		return MemberOfStaffWithAppUserLiteVoAssembler.create((MemberOfStaff)factory.getDomainObject(MemberOfStaff.class, memberOfStaffRefId.getID_MemberOfStaff()));
		
	}

//http://jira/browse/WDEV-15907
	public HcpRefVo getHcpRefByTaxonomyType(String extCode, TaxonomyType taxType)
	{
		MemberOfStaff domMos = getDomMosByTaxonomyType(extCode, taxType);
		if (domMos == null)
			return null;
		else
		{
			return new HcpRefVo(domMos.getHcp().getId(),domMos.getHcp().getVersion()); 
		}
	}

	//http://jira/browse/WDEV-15907
	public HcpMinVo getHcpMinByTaxonomyType(String extCode, TaxonomyType taxType)
	{
		MemberOfStaff domMos = getDomMosByTaxonomyType(extCode, taxType);
		if (domMos == null)
			return null;
		else
		{
			return HcpMinVoAssembler.create(domMos.getHcp());
		}
	}
}