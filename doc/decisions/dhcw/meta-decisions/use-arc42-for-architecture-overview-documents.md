# Adoption of Architecture Overview Documents

!!! info

    **Status**: Proposed

    **Level**: 2

    **Updated**: 2025-07-24

## Summary  

DHCW has well-established assurance processes for design that have been aligned to traditional waterfall methodologies for many years. As part of this approach, architects complete designs documented in Solution Architecture Documents (SADs), which are then peer-reviewed by the TDAG committee comprising experts from all major technical domains.

There are several issues associated to using SADs within the organisation:

* SADs reflect the initial design from an architectural perspective, but they do not reflect what gets implemented.
* SADs tend to be very lengthy documents and are difficult to consume for the end reviewers.
* SAD format doesn't take into account all areas of design concern.

## Drivers

The current assurance process results in SADs that often become obsolete once services are delivered, as changes made during implementation are not consistently captured or updated. This leads to a loss of accuracy in the documented state of the global architecture, reducing confidence in SADs as a reliable source of truth.  Decision drivers are as follows:

* Modern ways of working need to focus on iterative approaches to design.
* Design assurance is needed earlier and iteratively.
* Architecture needs to be a continuous activity, and documentation needs to reflect that.
* Architects are no longer singularly responsible for updating designs, and collaboration between disciplines to maintain the documentation is needed.
* Focus on end-to-end design architecture, rather than just software.
* Adopt a template format that AI can interpret and work with to improve their output when asked to contribute to projects.

## Options

Several options were identified that were considered for the review.

### Option 1 - Keep existing documentation standards

Retain the existing processes and design artefacts such as SAD, SRS, HLD, LLD.

### Option 2 - DHCW specific lightweight design template

DHCW would design a lightweight document template, managing the new format as a product.

### Option 3 - Adopt a recognised industry standard

 A lightweight format that can be adopted in line with other new tools, and maintained by the industry keeping it relevant to the latest architecture concerns.

## Options Analysis

### Option 1 Assessment

**Pros:**

* DHCW architects familiar with the existing artefacts and processes.

**Cons:**

* Documents are not kept up to date.
* Implementation does not match the design.
* Very lengthy documents and difficult to consume for the end reviewers.
* Not sustainable for the change to Product focussed delivery.
* Doesn't cover all aspects of the end to end design.

### Option 2 Assessment

**Pros:**

* DHCW can tailor a template for itself.
* Can utilise and complement our existing toolset.
* New lightweight design template.

**Cons:**

* DHCW responsible for maintaining the template.
* Architecture function will be responsible for training.

### Option 3 Assessment

**Pros:**

* Maintained and supported industry standard.
* Pre-existing templates and examples.
* Well known in the architect community.

**Cons:**

* DHCW responsible for maintaining the template.
* Architecture function will be responsible for training.

## Recommendation

After an initial assessment of the pros and cons for all options, option 3 was selected for further investigation to identify possible standards.  The following standards were considered:

* **C4 modelling** - excellent tool for modelling software, however lacking the end-to-end view.

* **Arc42** - An industry wide adopted methodology for documenting architecture, open source and supported, primarily based on Markdown.  Well documented template in multiple formats, with supporting documentation to assist architects through the information gathering process.  Many supporting examples.

After consideration, the recommendation is that DHCW will adopt the arc42 modelling template for solution architecture for the following reasons:

**1. Structured and Comprehensive Framework** - arc42 provides a well-defined, standardised template covering all critical aspects of architecture, including context, constraints, quality scenarios, building blocks, runtime views, and decisions. This ensures designs are documented holistically rather than inconsistently or partially, which is common with unstructured documentation.

**2. Decision-Centric and Maintainable** - It integrates architectural decisions (via ADRs) directly within the design structure, promoting traceability of why choices were made. This is more maintainable than freeform documents like traditional SADs, which often focus only on static design outputs rather than design rationale.

**3. Technology-Agnostic and Methodology-Neutral** - arc42 does not enforce any specific technology stack or delivery methodology (waterfall, agile, or hybrid). Its adaptability makes it ideal in mixed delivery environments like DHCW, where multiple approaches coexist.

**4. Widely Adopted and Supported** - It is an internationally recognised and peer-reviewed framework used across industries, with extensive guidance, examples, and community support. This ensures new team members can onboard quickly and understand documentation without bespoke organisational training.

**5. Promotes Consistency and Reuse** - By enforcing a common structure and language across projects and teams, arc42 reduces cognitive load, facilitates reviews and assurance processes (such as TDAG), and enables reuse of design knowledge across programmes, improving architectural governance maturity.

**6. Optimised for AI Interpretation and Generation** - The structured and consistent nature of the arc42 template makes it highly suitable for AI tools to interpret, generate, or update documentation efficiently. Its clear separation of concerns and predictable sectioning allow AI assistants to analyse, summarise, validate, or even draft architecture content with minimal ambiguity, enhancing productivity and ensuring documentation remains up to date.

For more information on arc42, go to [arc42.org](https://arc42.org/)
