# Cloud Hosting for Documents Capability

**Status**: Request for collaboration, decision
**Date**: 2025-18-07
**Governance**: Collaboration to be confirmed, TDA, TDAG?

## Situation: Context and Problem Statement

As part of the National Target Architecture (NTA) there is a business capability requirement for documents. However, there is currently a strategic misalignment regarding the choice of cloud platform for hosting documents. Two major programmes are influencing the direction:

- Azure: Backed by the Cloud Migration Programme, with a focus on core infrastructure, identity management, and operational services.
- Google Cloud Platform (GCP): Aligned with the Data Strategy, prioritising advanced analytics, machine learning, and integration with BigQuery.

A key architectural consideration is determining which cloud platform will host the operational microservices responsible for realising document-related business capabilities, in a way that balances both strategic alignment and technical suitability.

This indecision is introducing significant delivery risks:

- Duplication of effort: Separate DevOps pipelines, monitoring systems, and access control frameworks.
- Resource contention: Teams are being pulled in multiple directions, reducing focus and efficiency.
- Increased training overhead: Staff must become proficient in multiple cloud platforms.
- Lack of strategic clarity: Delays delivery, creates uncertainty, and hampers long-term planning.

This decision is critical, as it directly impacts funding, resource allocation, team coordination, and delivery timelines. Proceeding without a clear direction may result in duplication and rework—for example, initial implementation in Azure followed by migration to GCP—leading to delays, increased cost, and retraining requirements.

## Background: Decision Drivers

The Clinical Document Service aims to empower both citizens and health and care professionals through a secure, scalable, and accessible platform for storing and sharing clinical documents. It will be built on open standards, ensuring long-term sustainability and supporting informed clinical decision-making across organisational boundaries.

Designed for use by clinicians and citizens across Wales, the service will:

- Align with DHCW’s architecture principles and strategic direction.
- Align National Target Architecture (NTA) business capabilities to under lying technical architecture.
- Unify the user experience across diverse healthcare settings.
- Adopt a cloud-first approach, enabling a more scalable, flexible, and modular solution to meet future demands.
- Reduce complexity and improve delivery times.
- Enhance data quality through the use of industry standards and open architecture.
- Strengthen security and access controls.
- Provide a consistent, intuitive experience for end users.

To realise this vision, the service must be underpinned by a fit-for-purpose cloud hosting platform that meets its evolving technical and operational requirements. This will ensure:

- Clinical Document Service is positioned to meet its long-term goals, avoiding delays, duplicated effort, and architectural missteps.
- Cloud storage of clinical document binaries, accessible for operational use and analytics (e.g., NDAP).
- Microservice hosting, leveraging containerisation and orchestration for scalable, portable, re-useable and resilient service delivery.
- Core security services, including malware scanning, access auditing, and alignment with national standards.
- API management (e.g., Apigee), to support secure authentication, access control, logging, and monitoring.
- Unify business-as-usual (BAU) operations through the consistent use of technologies such as SOLR, streamlining search, indexing, and retrieval.

A clear and unified decision on the cloud platform is urgently needed to allow the delivery team to proceed with confidence, establish a stable foundation, and ensure alignment with future scaling and strategic direction. Ensuring the Clinical Document Service is positioned to meet its long-term goals, avoiding delays, duplicated effort, and architectural missteps.

## Assessment: Considered Options

Two platforms were evaluated, each aligned to distinct strategic objectives:

- Azure: Favoured by the Cloud Migration Programme for infrastructure, identity, and operational alignment.
- Google Cloud Platform (GCP): Favoured by the Data Strategy for data-driven capabilities, including integration with analytics pipelines and BigQuery.

For microservice infrastructure, the decision is not straightforward. While technical alignment and strategic direction remain important, the ultimate choice will likely be driven by financial considerations—such as total cost of ownership, licensing models, and long-term sustainability.

## Recommendation: Decision Outcome

Following a cross-functional meeting on 18/07/2025 with representation from NDR, Operations, and Architecture, the following decision was agreed:

- Document Binary Storage will be hosted in GCP, as this aligns with the Data Strategy and supports seamless integration with National Data and Analytics Platforms (BigQuery, machine learning and vertex AI).
- Clinical Data will be stored in the CDR
- Indexed data will continue to be stored in our current SOLR-based indexing solution. While SOLR is being maintained for business continuity, it is considered a transitional platform pending full migration to the strategic solution.
- Microservices supporting operational workflows and aligning with NTA business capabilities can be hosted on the most suitable platform from an infrastructure, resourcing, and deployment perspective—platform-neutral at this stage. This decision can be placed on lowest cost option.
- Google Apigee will provide the proxy layer and access mechanisms for users of the microservices.

This hybrid approach balances strategic alignment, delivery pragmatism, and long-term scalability.
