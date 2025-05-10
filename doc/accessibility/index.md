# Accessibility

!!! note
Work in progress, request for discussion

**Status**: first sketch, work in progress, request for collaboration

**Date**: Updated 2025-04-03

**Governance**: To Be Discovered; potentially a combo of this repo participants, DHCW UI/UX, NHS Wales UCB peers, etc.

## Context

We want to ensure accessibility for users, including users with disabilities. This is a fundamental aspect of providing an inclusive user experience, and an ethical principle, and a legal requirement.

The team has to decide on how to integrate accessibility into the product’s design and architecture. We believe this includes ensuring compliance with accessibility standards, and testing with users with disabilities, and delivering an experience that is usable for all users.

We believe that there's extensive knowledge and experience in the NHS Four Nations community, and in the global public health sector, and we want to leverage that.

## Drivers

Broadly, we want to provide excellent software that is accessible, and we want to use existing industry standards and practices, and we want to do software engineering that works well with accessibility automatic testing, and we want to not reinvent the wheel.

Specifically, Joel is programming the emergency department module authentication demo ASAP, and wants to make it accessible. We're currently learning about emergency department use cases, and there are many accessibility-related questions due to the nature of the emergency department.

## Options

The list below is simply a starting point. We believe that someone on our team TBD will have more knowledge and experience in this area, and will be able to provide more specific guidance, and will be able to research our peer organizations to gather best practices and standards.

For example research accessibility practices at:

* Our closest peer organizations e.g. NHS England, NHS Scotland, NHS Northern Ireland.

* Government digital practice organizations e.g. GOV.UK, 18F, etc.

* Public health organizations e.g. World Health Organization (WHO), Global Health Council (GHC), United Kingdom Royal Society for Public Health (RSPH).
United States Center for Disease Control (CDC), etc. 

### Web Content Accessibility Guidelines (WCAG)

The Web Content Accessibility Guidelines (WCAG) are a set of guidelines for making web content accessible to people with disabilities. 

There are various versions:

* Version 2.2. is the current version as of December 2024.

* Version 2.1. is the previous version which is more widely used because it's been around longer.

There are various levels:

* Level A is the minimum level of compliance
 
* Level AA is the moderate level of compliance.
  
* Level AAA is the maximum level of compliance.

TODO: we need to learn more about this area.

### Accessible Rich Internet Applications (ARIA)

The use of ARIA roles, states, and properties will be employed to improve accessibility for users with disabilities, particularly for dynamic content and advanced user interface controls (e.g., dropdowns, modal dialogs). These will be used in conjunction with semantic HTML elements where possible.

TODO: we need to learn more about this area.

### Multiple modality practices

The use of multiple kinds of interaction modalities, such as a using a mouse pointer, or keyboard commands, or voice recognition. 

TODO: we need to learn more about this area.

### Accessibility software engineering

We are evaluating accessibility software engineering practices and implementations, such as UI/UX design principles, and programming component frameworks and libraries.

TODO: we need to learn more about this area.

### Accessibility testing

Accessibility testing will be a part of the development lifecycle. 

We intend to leverage test automation tools, and accessibility compliance testing services, and if necessary manual testing, to identify and resolve accessibility issues before the release.

We intend to do real-world user acceptance testing with individuals with disabilities.

We intend to do continuous automatic testing to ensure that accessibility standards evolve with product iterations.

TODO: we need to learn more about this area.

### Training

Developers, designers, and content creators will undergo accessibility training to ensure awareness of the standards and best practices. 

This includes understanding how to create accessible content, design accessible interfaces, and properly implement ARIA.

TODO: we need to learn more about this area.

## Recommendations

TODO

## Consequences

The system will be more inclusive and usable for a wider range of people, including those with disabilities, such as visual impairments, motor impairments, and cognitive impairments.

* Possible slower release cycles due to the time required for accessibility testing and refinements.

* Potential additional development rigor and maintenance rigor, due to the complexity of implementing and testing accessibility features. This may include building to a higher standard to the benefit of all users, and may include increased use of resources e.g. time, money, equipment.

* As a side effect, increased legal and regulatory compliance, minimizing the risk of lawsuits or fines related to accessibility issues.

## Related

Some related decisions that as of this writing are work in progress and available on repo branches:

* add-authentication-for-emergency-department

* add-software-design-development-guidance
