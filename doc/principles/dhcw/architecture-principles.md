# Architecture Principles

!!! success "Adopted"

    DHCW adopts the [NHS Wales Architecture Principles](../nhs-wales/architecture-principles.md),
    approved nationally by the [NHS Wales Standards and Architecture Group (SAG)](../../design-authority/nhs-wales/sag-terms-of-reference.md).

    The rationale and implications below have been approved by the DHCW
    Technical Design Authority (TDA) and apply to DHCW only.

## 1. Start with User Needs

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#1-start-with-user-needs).

See also [User Centred Design Principles](user-centred-design.md).

??? info "Rationale"

    Building services based on a deep understanding of user needs is the most
    effective way to ensure they are adopted, deliver their intended benefits,
    and are easy to support. A user-centred approach reduces the risk of
    building the wrong thing, leading to better outcomes for patients and
    staff, and lower operational costs.

??? note "Implications"

    * Teams must conduct user research continuously throughout the design,
        development, and live operation of a service to ensure it continues to
        meet user needs.
    * The term "user" includes all consumers of a service. This includes
        end-users of a graphical interface (e.g. patients, clinicians) as well
        as technical users of an API (e.g. developers).
    * All significant design and development decisions must be based on
        evidence from user research.
    * Teams must use feedback and data from live services to iterate and
        improve the user experience.

## 2. Design for Change

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#2-design-for-change).

See also [Digital Products and Software Engineering](digital-products-and-software-engineering.md).

??? info "Rationale"

    Business, clinical, and technology requirements will inevitably change.
    Architectures that are rigid, monolithic, and tightly coupled make it
    difficult, risky, and expensive to respond to these changes.
 
    By designing systems that are modular with well-defined interfaces, we can
    isolate the impact of changes, reduce complexity, and enable teams to
    deliver new features and improvements independently and efficiently.

??? note "Implications"

    * Services must be designed as modular components with single, well-defined
        responsibilities. Communication between components must be via stable,
        versioned APIs.
    * Services should be configurable to handle variations in environment or
        behaviour without requiring code changes and redeployment.
    * A comprehensive suite of automated tests is essential to provide the
        confidence needed to refactor and make changes safely.
    * Automated CI/CD pipelines must be in place to make the process of testing
        and deploying changes frequent, low-risk, and reliable.
    * Significant architectural decisions and their trade-offs must be
        documented in Architecture Decision Records (ADRs).
    * Third-party dependencies must be carefully managed with a clear strategy
        for updates to avoid technical debt and security vulnerabilities.

## 3. Embed Security and Privacy by Design

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#3-embed-security-and-privacy-by-design).

See also [Security and Identity Principles](security-and-identity.md).

??? info "Rationale"

    To protect sensitive health and care data and maintain public trust,
    security cannot be an afterthought. By embedding security and privacy
    considerations into every stage of design and development, we build
    services that are secure by default.

    This proactive approach reduces the risk of data breaches and ensures
    compliance with legal obligations.

??? note "Implications"

    * Users and systems must be granted the minimum level of access and
        permissions necessary to perform their functions.
    * Services must only collect, process, and retain the data that is
        absolutely necessary for their specified and legitimate purpose.
    * Teams must follow secure coding practices (e.g., OWASP Top 10), conduct
        regular code reviews, and use tools to scan for vulnerabilities in code
        and third-party dependencies.
    * Security must be continuously validated through automated testing, 
        regular vulnerability scanning, and periodic penetration testing for
        high-risk services.
    * All services must demonstrate conformance with relevant data protection
        and security standards on a continuous basis.
    * All security-relevant events must be logged to a secure, immutable audit
        trail to support monitoring, investigation, and incident response.

## 4. Use the Welsh Health Data Space

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#4-use-the-welsh-health-data-space).

??? info "Rationale"

    Architectures based on point-to-point data integrations and data sharing
    are complex, brittle, and expensive to maintain. This principle avoids
    these issues by establishing the Welsh Health Data Space as a central hub
    for data exchange, removing the need for direct data messaging, copying and
    migrations between individual applications. This radically simplifies the
    landscape, ensuring that all services are working from a consistent, shared
    understanding of data. It removes ambiguity and reduces the clinical risk
    of decisions being made on stale or conflicting information.

    While applications retain stewardship and mastery of their own data, their
    mandatory, real-time synchronisation with the Welsh Health Data Space is
    what ensures consistency, quality, and clear provenance across the system.
    This model provides a complete, trustworthy view of patient information.
    Furthermore, because data is persisted in the shared record, it mitigates
    the clinical risk of information being unavailable if a source application
    goes offline. In principle, it also allows new, simpler applications to be
    developed that can use the shared record as their primary data layer.

??? note "Implications"

    * Services must read data from the Welsh Health Data Space, treating it as a
        source of truth, updating their internal data store as appropriate. 
    * Services must write data changes to the Welsh Health Data Space with
        minimum delay, so that other services always have access to current
        data. 
    * All interactions with the Welsh Health Data Space occur through versioned,
        documented, and discoverable open APIs. Direct database access is
        prohibited.
    * Services should not share data directly with other services, because this
        excludes other services, and will compromise the reference data layer’s
        integrity as a single source of truth.  
    * This principle applies to any data that is relevant to another service. A
        catalogue of these data must be maintained. Examples include, but are
        not limited to:
        - Patient demographics
        - Longitudinal patient record data (e.g. events, results, medications)
        - Reference data (e.g. clinical terminologies)
        - Practitioner and staff information
        - Documents and medical images
    * Clear stewardship for each data entity must be established. The steward
        is responsible for the quality, availability, and lifecycle management
        of that data.
    * Procurement processes for new systems must contractually mandate
        compliance with this principle, ensuring any proposed solution will
        integrate with the Welsh Health Data Space via the required APIs.
    * Existing systems must have a clear roadmap to integrate fully with the
        Welsh Health Data Space.

## 5. Enable Interoperability with Open APIs

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#5-enable-interoperability-with-open-apis).

See also [Open Architecture & Integration Principles](open-architecture.md).

??? info "Rationale"

    A modular architecture, where services communicate via open APIs, is
    essential for creating a flexible and innovative digital ecosystem. This
    approach prevents vendor lock-in, allows individual components to be
    replaced or upgraded without impacting the entire system, and fosters a
    competitive market where suppliers compete on quality.

    By making data and functionality programmatically accessible, we enable
    seamless integration and the creation of new, composite services that can
    better meet user needs.

??? note "Implications"

    * Services must be designed with their API as the primary interface. The
        API contract should be defined early in the development process.
    * APIs must adhere to widely adopted open standards. E.g. For health data,
        HL7 FHIR standards must be used where applicable.
    * All APIs must be documented and published in a central API catalogue,
        making them easy for other teams to find and consume.
    * A clear API versioning strategy must be in place to allow for evolution
        without breaking existing consumer applications.
    * System-to-system integration must not use direct database connections,
        shared file systems, or proprietary protocols. All integration must be
        via the published APIs.

## 6. Select for Reuse, Use Shared Platforms

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#6-select-for-reuse-use-shared-platforms).

??? info "Rationale"

    Reusing proven platforms and components accelerates the delivery of new
    services, reduces the total cost of ownership, and improves consistency
    across the digital estate. It avoids the duplication of effort and the
    proliferation of solutions that solve the same problem in slightly
    different ways.

    When a suitable component does not exist, we must build new capabilities
    with reusability in mind. This fosters a collaborative engineering culture
    and ensures that our investment in building a new component provides value
    beyond a single project. This principle applies to both building new
    services and procuring third-party solutions.

??? note "Implications"

    * Teams must first search for and evaluate existing common platforms or
        components before starting new development. A central catalogue of
        approved platforms and components must be maintained and consulted.
    * Using an existing, approved platform is the default choice. A decision to
        build a new component to solve a problem that is already addressed by
        a common platform requires a documented exception (e.g. an ADR).
    * Any new component or service that has the potential for reuse must be
        built with a clear, versioned API, be well-documented, and be
        independently deployable.
    * Every common platform and component must have a clear owner and a
        defined support model to manage its lifecycle, including maintenance,
        versioning, and eventual retirement.
    * There must be a clear process for teams to contribute improvements and
        bug fixes back to the common platforms and components they use.

## 7. Deliver Sustainable and Affordable Services

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#7-deliver-sustainable-and-affordable-services).

??? info "Rationale"

    To ensure long-term value and responsible use of public resources, services
    cannot be built with only short-term goals in mind. A sustainable approach
    considers the total cost of ownership, the long-term health of the technical
    solution, and its environmental impact.

    This holistic view prevents the creation of services that become
    prohibitively expensive to run, impossible to maintain due to technical
    debt, or misaligned with our environmental responsibilities. 

??? note "Implications"

    **Financial sustainability**

    * Whole-life cost models must be developed during service design, covering
        development, hosting, support, and eventual decommissioning. 
    * Operational funding for services must be identified and secured beyond
        any initial project funding.
    * Cloud services must be managed using FinOps best practices to control and
        optimise costs.
    
    **Technical sustainability**

    * Technology choices must be supportable and maintainable for the expected
        life of the service, considering skills availability and vendor
        viability.
    * Technical debt must be actively managed, tracked, and addressed as part
        of the development lifecycle.
    * A clear strategy for dependency management, patching, and component
        obsolescence must be in place.

    **Environmental sustainability**
    
    * Design choices should favour resource efficiency (e.g. efficient code,
        optimised data storage, appropriate scaling).
    * Where possible, leverage cloud provider tools to measure, report on, and
        reduce the carbon footprint of services.
    * Procurement of hardware and services should consider the environmental
        impact of the entire supply chain.

## 8. Be Cloud Capable

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#8-be-cloud-capable).

See also [Cloud and Infrastructure Principles](cloud-and-infrastructure.md).

??? info "Rationale"

    Leveraging public cloud services accelerates the delivery of value by
    providing on-demand access to scalable, resilient, and secure
    infrastructure. This approach allows teams to focus on developing
    user-centric services rather than managing underlying hardware. The public
    cloud offers significant advantages in agility, cost-effectiveness, and
    access to a wide range of modern, managed services. This principle supports
    our goals for sustainability and operational excellence.

??? note "Implications"

    * All new services must be designed and built to run on a public cloud
        platform. Modernisation of existing services should include a plan for
        cloud migration.
    * A decision to host a service outside of the public cloud must be
        justified and documented in an Architecture Decision Record (ADR),
        citing specific technical, security, or legislative constraints that
        cannot be met by available cloud offerings.
    * To mitigate vendor lock-in, services should be designed with portability
        in mind. Favour cloud-agnostic technologies like containers and
        standard open-source software. The use of provider-specific services
        that are not easily portable must be a conscious trade-off, justified
        by significant value.
    * Teams must adopt practices for monitoring, managing, and optimising cloud
        costs. Budgets must be planned for operational expenditure models.
    * A commitment to developing and maintaining cloud engineering, security,
        and architecture skills within teams is required. 
    * Teams must understand and operate within the shared responsibility model
        for security in the cloud, implementing appropriate controls for
        identity, access, network, and data protection.

## 9. Build for Modern Browsers

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#9-build-for-modern-browsers).

See also [User Centred Design Principles](user-centred-design.md).

??? info "Rationale"

    Building services for the web is the most effective way to ensure they are
    accessible to the widest possible audience, regardless of their device or
    operating system. This approach eliminates the significant cost, time, and
    complexity associated with developing, distributing, and maintaining
    separate native applications for different platforms.

    A single, responsive, standards-compliant web application simplifies
    deployment, reduces support overhead, and allows teams to leverage the
    robust security, accessibility, and performance features inherent in modern
    evergreen browsers. It ensures a consistent user experience and means users
    can access services instantly without needing to install anything.

??? check "Implications"

    * Native mobile or desktop applications will not be built unless a specific,
        compelling user need is identified that cannot be met by a web
        application. This requires a documented exception.
    * User interfaces must be fully responsive, providing a functional and
        intuitive experience on all common device sizes, from mobile phones to
        large desktop monitors.
    * All services must comply with Web Content Accessibility Guidelines.
    * Services must be tested and functional on the latest versions of all
        modern, evergreen browsers (e.g., Chrome, Firefox, Edge, Safari).
        Support for older, non-evergreen browsers (like Internet Explorer) is
        not required.
    * Solutions must not rely on browser plugins or extensions.

## 10. Design for Public Internet

See the [NHS Wales principle statement](../nhs-wales/architecture-principles.md#10-design-for-public-internet).

??? info "Rationale"

    Building services that are capable of being safely and securely deployed
    over the public internet is a foundational goal. Adhering to modern
    internet standards (like HTTPS, TLS 1.2+, REST, OAuth 2.0, OpenID Connect)
    ensures services are secure, resilient, and interoperable by default.

    This approach avoids vendor lock-in from proprietary protocols, simplifies
    integration between different systems, and allows services to be accessed
    from a wide range of standard devices without special software or network
    configurations. It provides the architectural flexibility to choose the
    most optimal and cost-effective deployment model, whether on-premises or in
    the public cloud, without being constrained by private network dependencies.

??? note "Implications"

    * Services must be designed to operate securely over the public internet.
        Dependencies on private networks should be for specific, justified
        use-cases and not the default assumption.
    * All data-in-transit must be encrypted using current, recommended versions
        of TLS. APIs should be exposed over HTTPS, following RESTful principles
        or other modern API standards.
    * User and system authentication / authorisation should leverage open
        standards like OAuth 2.0 and OpenID Connect.
    * When procuring or commissioning new services, there must
        be a requirement for adherence to open internet standards, avoiding
        solutions that mandate proprietary clients or protocols.
    * Existing systems that do not conform must have a clear roadmap for
        modernisation or be fronted by a standards-compliant API gateway or
        facade.
