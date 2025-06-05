# Architecture Principles

!!! warning

    Proposed changes to these principles are under review by the DHCW TDA

## Deliver sustainable services

Digital services need to be delivered sustainably.

??? info "Rationale"

    Digital services need to be sustainable, giving specific consideration to
    forecasting future demand and consequent environmental, financial and
    technical costs.

    The impact of digital services on carbon emissions should be considered
    holistically, including for example: supply chain; energy; direct delivery
    and wider social economic costs.

    The financial costs of digital services should be considered on a whole life
    basis, including live operations and decommissioning.

    The technical costs of digital services should consider the capability and
    capacity required throughout the whole lifecycle, including for example:
    dependencies, skills and knowledge, obsolescence.

## Be accessible through any modern browser

All digital services need to be browser based and to comply with open web
standards.

??? info "Rationale"

    Digital services should be accessible through any modern browser on any
    modern device.  

    This enables more efficient device management and simplifies deployment of
    new digital services to users, also supporting a wider range of device
    formats including mobile.

    Also leverages security, functionality and accessibility features embedded
    in modern browsers and web technologies.

## Be public internet capable

All digital services should use internet standards and protocols so that they
can be deployed over public internet.

??? info "Rationale"

    Digital services should be capable of being safely and securely deployed
    over public internet. 

    This is an architecture principle which enables choices around optimal
    deployment. To provide enhanced security a private network deployment will
    often be preferred.

## Be public cloud capable

Digital services should move to the public cloud unless there is a clear reason
not to do so.

??? info "Rationale"

    Cloud infrastructure provides significant advantages and helps to more
    easily deliver important architecture characteristics such as scalability
    and resilience.

    Digital services should carefully manage dependencies, in order to avoid
    ‘lock in’ to one cloud provider.

## Read and write data to the NDR single data layer

All digital services should read and write to the NDR single data layer through
standard open APIs.

??? info "Rationale"

    If all digital services read and write to a single data layer our
    architecture is much simpler than each service staying in sync with others
    through messaging.

    Having one source of truth for data and making it available via standard
    APIs provides more comprehensive and consistent data for clinical use,
    reduces the need for compensation logic (to resolve duplication, variation,
    conflicts, etc).

    By writing data to the single data layer digital services make it available
    to all other services in the NHS Wales architecture.  Services should write
    data as close to real time as possible.

    By reading data from the single data layer digital services can validate
    that they have current and comprehensive data. Services should check for
    updated data regularly.

    APIs should be included in an API catalogue, fully specified, and supported
    by developer resources, test environments, etc.

## Meet or exceed cyber security and privacy standards

All digital services must meet or exceed cyber security and privacy standards.

??? info "Rationale"

    It is critical that we maintain public trust in how we hold, share and use
    data.

    We need to maintain a safe and secure data infrastructure that protects
    health and care services, patients and the public. The digital architecture
    of the health and care system needs to be underpinned by clear and commonly
    understood data and cyber security standards, mandated across the NHS, to
    ensure we are secure by default and that the penalties for data breaches are
    effective in protecting patients’ privacy.

    This should be shown through a statement of conformance to security
    standards and through non-functional testing. Since cyber security standards
    change, conformance will need to be regularly assessed and maintained
    through the lifecycle of the service.

## Use common platforms and components

Digital services should use common platforms and components where possible.

??? info "Rationale"

    Building on common platforms and reusing modular components reduces
    duplication and variation, simplifies development and operations, and drives
    efficiency and optimisation.   

    If suitable platforms and components do not already exist, new digital
    services should build platforms and components for potential reuse by other
    services.

## Design for users by understanding user needs

All digital service should be designed for users, based on understanding user
needs and engaging with users throughout design development and operation
lifecycles.

??? info "Rationale"

    Designing for users leads to better digital services which are more likely
    to be used and to deliver intended outcomes and benefits. Well designed
    digital services reduce user support and service management requirements.

    Users includes end users (e.g. patients and healthcare professionals for
    digital services which have an user interface) as well as developers (e.g.
    for components which have an API).

    All user interfaces should comply with legal requirements on accessibility. 

    All user interfaces should have locale (geographic/organisational) and
    internationalisation (language) capabilities.

## Be interoperable through Open APIs

All digital services should be interoperable with others, exposing data and
functionality using open standards through APIs.

??? info "Rationale"

    Open standards permit interoperability between different regions and systems
    but they also, crucially, permit a modular approach to IT in the NHS, where
    tools can be replaced with better alternatives as vendors develop better
    products. This, in turn, will help produce market conditions that drive
    innovation, in an ecosystem where developers and vendors continuously
    compete on quality to fill each niche, rather than capturing users.

## Design for change

Digital services should be designed to make future changes easy.

??? info "Rationale"

    There will always be a need to make future changes to digital services. In
    poorly designed architectures changes can be difficult, expensive and
    time-consuming to implement.

    Digital services should be designed to reduce complexity and ambiguity, and
    to simplify development and operations.  For example, by documenting
    architectural decisions, implementing good coding standards, using widely
    supported standards and technologies, preferring configuration management to
    code customisation, ensuring extensible architectures, reducing third party
    dependencies.
