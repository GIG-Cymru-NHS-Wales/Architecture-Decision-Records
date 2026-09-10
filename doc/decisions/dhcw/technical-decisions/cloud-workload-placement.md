# Cloud Provider Workload Placement

!!! info

    **Status**: Final
    
    **Level**: 4
    
    **Updated**: 2025-11-19

## 1. Summary

DHCW has adopted a "Cloud First" strategy for hosting services. As such, it has established commercial arrangements for hosting services and data in both Microsoft Azure (Azure) and Google Cloud (GC, formerly Google Cloud Platform) and is undertaking a major programme to transition services from on-premises hosting to Public Cloud. Alongside this, new services are being developed as Cloud-native, both within the NDR Programme (primarily GC) and Operational (mix GC/ Azure) spheres. There is a need for guidance to aid teams in choosing the right provider for their scenarios.

This ADR provides a decision framework to support suitable selection of Cloud provider for specific products and services.

## 2. Drivers

The decision framework to support selection of Cloud provider for DHCW products and services is required at this point to inform planning for both the Cloud Transition Programme, which aims to migrate all services from on-premises data centres by April 2028, for novel services being developed as Cloud-first, in line with the DHCW Cloud Strategy, and for existing services (either Cloud-hosted or otherwise) being rearchitected to take advantage of Cloud capabilities.

This decision framework is established based on the following assumptions:

2.1. at this stage in DHCW's Cloud maturity, individual workloads will not normally be deployed as multi-cloud (i.e., each service will be deployed to one or other Cloud provider)

2.2. GC and Azure are the Public Cloud providers in scope, as it is with these that DHCW has existing commercial relationships.

The reader should note that the Cloud Transition Programme (CTP) has a limited timescale and specific scope, and the DHCW operational workforce does not broadly have extensive experience of Public Cloud; as a consequence, it is most likely that initial workload migrations undertaken within the CTP will of necessity be more "tactical" than "transformative".

Placement decisions made to support migrations within the CTP should not be seen as decisive in terms of the future workload placement of a particular Product set - it is more than likely that as applications evolve over time, architectural considerations regarding choice of Cloud provider for hosting particular workloads may change.

## 3. Workload Placement Considerations

The factors which should be considered when determining placement of individual workloads can be grouped into four main areas of consideration: External factors relating to Governance and Capability; Application Affinity, Integration and Data Gravity; Technical Fit; and Commercial. Gartner recommend that in most cases commercial considerations should be of limited importance in decisions around workload placement – there is an exception to this, which will be noted below.

## 4. External Factors relating to Governance & Capability

### 4.1. Information Governance/ Data Sovereignty

Both Azure and GC align with the requirements of the [NHS Cloud Security good practice guide](https://digital.nhs.uk/services/cloud-centre-of-excellence/cloud-security-good-practice-guide), which underpins the Health and Social Care data risk model, the key model used within the NHS Wales Cloud Risk Assessment process (which NHS Wales bodies have been instructed to use by Welsh Government). It should be noted, however, that whereas Azure presents multiple regions in the UK which expose the majority of its cloud functionality portfolio, GC has only a single regional location in the UK, with multiple alternative regions within the EU – this may impact on DR designs for services and data hosted in GC.

Whilst this, in and of itself, aligns with the recommended good practices as described in the NHS Cloud Security good practice guide, it should be noted that NHS England has issued [guidance for its own services](https://digital.nhs.uk/data-and-information/looking-after-information/data-security-and-information-governance/nhs-and-social-care-data-off-shoring-and-the-use-of-public-cloud-services), instructing that where class 3, 4 or 5 data is identified within a risk assessment, it should NOT be hosted outside of the UK without additional GDPR Risk assessments and executive-level approval.

### 4.2. Quality and resilience of connectivity

At the time of drafting this ADR, connectivity between Cloud providers and the NHS Wales WAN is not equal in this respect - whilst there are separate direct connections from the DHCW data centres to one region in Azure, all other connectivity at this point is made using site-to-site VPNs across the shared NHS Wales Internet Gateway and is thus subject to the limitations of shared bandwidth.

Work is underway to improve this situation as part of the Cloud Transition Programme. Once this work is completed, it is expected that there will be no significant difference in connectivity between NHS Wales and the two Cloud providers. It is also expected that this work will improve direct connectivity between the two Cloud providers significantly.

### 4.3. Operational support capacity and capability in relevant technologies

Whilst there are operational teams with some experience in both Cloud providers, at this stage outside of particular specialist areas most support teams have had relatively little exposure to Cloud services. Whilst, for those services migrating to IaaS or with limited adoption of PaaS the change in operating model is initially likely to be limited, the availability of skilled operational support should be considered where there may some adoption of more modern Cloud technologies within an application's architecture.

### 4.4. Commercial Off-the-Shelf (COTS) product support

Where a service is delivered using COTS products, there may be considerations to be addressed with the supplier of the software as to whether particular cloud deployments will be supported by them (either in terms of architectural limitation or supplier limitation).

### 4.5. Availability of Cloud Provider Third-line Support resources

As described in the Commercial Considerations section below, the various contractual arrangements provide access to expert Cloud provider support resources (via Microsoft Unified Support or the GC equivalent). Whilst these are nominally break/fix arrangements, both contracts (in slightly different ways) also provide the ability to access more proactive support resources, e.g., for design reviews etc).

### 4.6. Cloud-Provider-specific tooling to support monitoring and/or management of resources

Both Azure and GC have extensive tooling to support monitoring, integration with CI/CD pipelines and other resource management activities. It is likely that following the establishment of the enterprise monitoring function, most monitoring will rely on third-party observability platforms which will integrate with both platforms. Similarly, each provider integrates well with the major CI/CD toolsets, with little real disparity of functionality.

## 5. Application Affinity, Data Gravity and Integration Considerations

### 5.1. Application Affinity

Some DHCW applications rely heavily on supporting services (e.g., Welsh Clinical Portal relies on WEFA for much of its forms-driven content, some WEFA forms rely heavily on data from the Terminology Service as part of form composition). For obvious latency reasons, as well as to reduce complexity in network management, there is sense in locating such services where practical in the same Cloud provider.

Application affinity may not solely be driven by the location of related applications contributing to the functionality or operation of a service – it may also be driven by a recognition that a particular product group, for example, has significant development or operational support skills in a particular Cloud provider, and so placement decisions may reflect this.

### 5.2. Data Gravity

For obvious latency reasons, it is generally considered to be good practice for applications to be placed in the same cloud as the data sources they consume as well as data sinks they write to for transactional purposes. This is particularly a consideration for the placement of what might be termed “centres of data gravity”, i.e., large-scale shared databases etc.

### 5.3. Asynchronous integration (messaging) at volume

Many DHCW applications and services use asynchronous messaging to exchange data. Although the nature of these flows is such that timeliness of transmission and receipt is not an over-riding consideration (hence the use of asynchronous messaging), some flows are at high scale and/or frequency and/or payload size. In such cases, this should be a consideration when determining hosting locations of services and components.

### 5.4. Synchronous integration requirements supporting application functionality

A number of DHCW applications rely on data hosted in, and provided by, other DHCW services (e.g., Welsh Clinical Portal consumes data from web services and APIs belonging to Welsh PAS, WCRS, WRRS), and there is a strategic ambition for many services to consume (or provide) real time data relating to the longitudinal record as exposed by the Care Data Repository. In general individual interactions will be relatively small: however, the potential egress charges (see below) and data latency associated with cross-cloud interactions may be a consideration when determining hosting locations, particularly where there are significant quantities of synchronous interactions and/or large data payloads involved.

### 5.5. Egress charges and API management effects

Cloud providers charge additional costs where data is exported from their particular platform, known as data egress charges, but in general do not charge for data traffic WITHIN the relevant Cloud platform. Whilst these charges may prove significant for bulk data movement (e.g., backing up of data held within a cloud platform to another location/ cloud platform), it is anticipated that for routine data integration, these charges are not likely to be significant. Nonetheless, they remain a consideration when considering hosting of applications with substantial data flows for integration or reporting purposes.

The effects of the use and location of API gateways may also have a bearing on the behaviour of data flows between applications and supporting workloads – these are not always obvious, but should be considered as part of workload placement planning.

## 6. Technical Fit

It is clear that different cloud providers exhibit different strengths in terms of technical capabilities – if particular technical ability is key to a service, then clearly this should form part of the workload placement decision.

### 6.1. AI/ML capabilities

At the time of writing, Azure and GC have markedly different capabilities in the area of AI/ML. Whilst Azure excels in integrating AI/ML capabilities with other Microsoft products and tools and in supporting the building of AI features at scale, GC has focused its AI/ML offerings in areas of AI innovation such as Natural Language Processing, and in building custom machine learning models. GC is also well integrated with R&D tools such as Jupyter Notebooks and TensorFlow.

### 6.2. Ease of adoption of open-source technologies

Whilst both platforms are well-aligned in their ability to support the wider DHCW architecture principles, product groups with significant reliance on Kubernetes and other major open-source projects should give consideration to adopting GC, particularly where there is no requirement for considerations around direct integration with other Microsoft ecosystem products such as Entra ID.

## 7. Commercial Considerations

As previously indicated, Gartner’s advice is normally that commercial considerations should not be considered as a major factor when planning for workload placement – DHCW has multi-year commercial arrangements with both Cloud platforms which provide discount over the published price lists, and these exhibit a number of similarities despite varying markedly in scale and some details of applicability.

The commercial arrangement with Google Cloud is in the final year of the current term. The current arrangement has a consumption commitment each year of a minimum of $600K, with a maximum contract value of £10M over the term. This means that there is a firm commitment on the part of DHCW to spend $600K in each contract year; whilst this has been difficult to achieve in earlier years of the contract, the rapid expansion in use of the CDR and the greater use of GC technologies within the wider NDR programme mean that this consumption commitment is expected to be easily met for the remainder of the contractual term. The nature of the GC contract is that some non-GC-specific Google services can also be purchased through the contract; as such, it has been used to fund the Apigee platform, Security Command Center, Looker licences etc.

The equivalent Azure contract, known as a MACC, was renewed in early Autumn 2025, for a three year period. The consumption commitment within the Azure contract is for a minimum of £5.6M over the three years of the agreement with no annual minimum spend or realistic maximum value.

Spend in either contract has a knock-on impact on support costs for the relevant platform. Whilst the Google arrangement increases the annual support bill by 25% of any additional GC spend, the relationship between consumption and higher support costs is less transparent with the Microsoft equivalent, not least because of the impact of other non-cloud Microsoft contractual arrangements such as the Microsoft 365 Enterprise Agreement.

There are two notable areas in which adoption of Azure can be beneficial where Microsoft Server-based workloads are involved. Firstly, Microsoft licensing conditions often advantage Azure adoption as opposed to other Clouds – for example, aspects of SQL Server availability technologies require multiple licences in other Clouds but can be invoked with a single licence in Azure.

In addition to this, the new contract features significant inducements to host Microsoft Server-based workloads within Azure, particularly where these are migrated from on-premises predecessors (the so-called “Hybrid Use Benefit” facility). Under this arrangement, Microsoft Server-based workloads migrated from on-premises to Azure can benefit from both concurrent licensing for the period of migration and, subsequently, an extremely favourable “exchange rate” between legacy on-premises licences and the Cloud equivalents.

### 7.1. Commitment shortfalls

As previously described, both commercial arrangements contain contractual commitments. Whilst it is extremely likely that the GC commitment can be met for the remainder of the term of the current contract, to avoid a shortfall in spend  against the commitments in the new Azure MACC there will clearly need to be significant adoption of Azure services over the contract period.

## 8. Workload Placement Decisions

Gartner advice is that workload placement policies should recognize the risk of commitment shortfalls such as that which DHCW currently has with the new Microsoft MACC, and where shortfalls such as these exist workload placement policies should legitimately be framed to “favour” a particular provider until the risk of shortfall is mitigated. This is clearly the case for the immediate term, particularly given the large quantity of existing Microsoft-based workloads in the DHCW portfolio.

In all cases, workload placement should be regularly reviewed by application development leads and technical architects, so that as application teams adopt more cloud-native approaches and/or legacy technologies are retired, appropriate workload placement decisions can be made.

Workloads should therefore be placed according to the following table.

| Type of workload | Example | Target Cloud | Factors | Further considerations |
| --------------- | ------- | :------------: | ------- | ---------------------- |
| Migrating to IaaS, uses Microsoft Server suite (rehost) | 3rd-party COTS application | Azure | Commitment shortfall/ licensing benefits | |
| Migrating to PaaS, where Azure Hybrid Use Benefit may apply (rehost/replatform) | Transactional databases containing application-specific data | Azure | Commitment shortfall/ licensing benefits | |
| Migrating to IaaS, open-source OS (rehost) | SFTP Gateway servers supporting LIMS2 integrations | Either | Support team capability, Technical fit | If there is a dependency on Entra, then Azure may be preferred |
| Migrating away from legacy technologies (refactor) | WIS/ Choose Pharmacy | Either | Support team capability, Affinity/ data gravity/ integration, Technical fit | |
| New development | UEC module, Integration Hub | Either | Support team capability, Affinity/ data gravity/ integration, Technical fit | In the case of Integration Hub, a case may be made for “both” to be an ambition |
| Migration of very large shared databases including significant refactoring of both database and functional tiers | WRRS/ WCRS | Either | Support team capability, Affinity/ data gravity/ integration, Technical fit | In most cases likely target will be GC, to facilitate migration to/ integration with CDR |
