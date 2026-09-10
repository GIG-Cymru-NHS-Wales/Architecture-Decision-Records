# FHIR for Interoperability First

!!! info

    **Status**: Approved

    **Level**: 3

    **Updated**: 2025-10-03

## Summary

This Architecture Decision Record (ADR) mandates that Fast Healthcare Interoperability Resources (FHIR) be the primary standard for all new healthcare interoperability initiatives. This decision is driven by both the Welsh Health Circular (WHC/2023/018), which mandates FHIR for NHS Wales, and the strategic alignment with the National Data Resource (NDR), which is built on the Google Healthcare platform and natively uses FHIR. Adopting a FHIR-first approach will enhance data exchange, accelerate development, and ensure our systems are future-ready.

## Drivers

The primary driver for this decision is the Welsh Health Circular (WHC/2023/018), which mandates the use of FHIR. This is further supported by the Digital Health and Care Wales (DHCW) investment in the National Data Resource (NDR), a strategic platform based on Google Healthcare's FHIR-native infrastructure. To maximize the value of the NDR and ensure seamless data integration across the Welsh healthcare ecosystem, it is essential to standardize on a common interoperability framework.

* **National Mandate**: The Welsh Health Circular (WHC/2023/018) formally mandates FHIR as the foundational interoperability standard for all IT and digital systems across NHS Wales, aligning with the FAIR data principles (Findable, Accessible, Interoperable, Reusable).
* **Strategic Alignment**: We need to align our interoperability standards with the core platform of the NDR.
* **Consistency**: A single, nationally adopted standard is required to prevent fragmented data silos and reduce integration complexity.
* **Future-Proofing**: We must adopt a modern, actively developed standard to ensure the long-term viability of our healthcare systems.

## Options

### 1: Adopt a "FHIR-First" Policy

Mandate that FHIR is the default, preferred standard for all healthcare data interoperability projects.

### 2: Allow Individual Project-Based Standards

Permit teams to select their own interoperability standards (e.g., HL7v2, openEHR) on a case-by-case basis.

## Options Analysis

### Option 1: Adopt a "FHIR-First" Policy

**Pro:**

* **Enhanced Interoperability**: Ensures all new systems can seamlessly connect with the National Data Resource and other FHIR-compliant systems.
* **Accelerated Development**: Teams can leverage a growing ecosystem of FHIR tools, libraries, and expertise, reducing development time and cost.
* **Vendor Support**: FHIR is widely adopted by major health IT vendors, improving our ability to integrate with third-party systems.
* **Future-Ready**: FHIR is a modern, evolving standard that will keep our architecture current.

**Con:**

* **Legacy System Integration**: Integrating with older systems that do not support FHIR may require custom middleware or converters, adding complexity.
* **Niche Use Cases**: For some highly specialized use cases, FHIR may not be the most efficient or suitable standard.
* **Bottlenecks**: Increased dependency on FHIR Standards team for FHIR Profiles where none exist for a specific use case could introduce delays.

### Option 2: Allow Individual Project-Based Standards

**Pro:**

* **Flexibility**: Teams can choose the standard that is the absolute best fit for their specific, immediate requirements.
* **Commercial Scope**: Ability to procure 3rd-party systems and products that don't support FHIR,
providing potential access to a wider set of products.

**Con:**

* **Increased Complexity and Cost**: Leads to a fragmented technology landscape, requiring multiple integration engines and skillsets, driving up costs.
* **Data Silos**: Creates barriers to data sharing between systems that use different standards, undermining the goal of a national data resource.
* **Reduced Reusability**: Prevents the reuse of common components and expertise across projects.

## Recommendation

We will adopt a **"FHIR-First"** policy.

FHIR is to be considered the primary and default standard for all healthcare interoperability initiatives within DHCW. This approach provides the most significant long-term benefits by aligning our technical architecture with the strategic National Data Resource, fostering a cohesive data ecosystem, and positioning us to take advantage of modern healthcare technology.

### Consequences

* **Pro**: **Improved Interoperability**: Aligns systems with the National Data Resource (NDR) and promotes seamless data exchange.
* **Pro**: **Accelerated Development**: Teams can reuse common tools and resources, speeding up project delivery.
* **Pro**: **Future-Ready**: Adopting a modern, evolving standard ensures our architecture remains current.
* **Con**: **Legacy System Challenges**: Integrating older, non-FHIR systems may require additional effort and custom solutions, although this is generally true for any non-standards based system.
* **Con**: **Potential for Misfit**: FHIR might not be the best choice for every situation.

### Confirmation

Compliance with this decision will be enforced by the Technical Design Assurance Group (TDAG) during solution review.

If a team believes FHIR is not suitable for their specific use case, they must document their reasoning and propose an alternative. **This proposal must be submitted to the Technical Design Assurance Group (TDAG) in the form of a new Architecture Decision Record for review and approval before proceeding.**

## More Information

* [Welsh Health Circular (WHC/2023/018): Introduction of HL7 FHIR as a foundational standard in all NHS Wales Bodies](https://www.gov.wales/introduction-hl7-fhir-foundational-standard-all-nhs-wales-bodies-whc2023018)
