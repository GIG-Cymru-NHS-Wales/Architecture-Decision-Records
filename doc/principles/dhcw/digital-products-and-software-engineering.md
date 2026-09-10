# Digital Products & Software Engineering Principles

!!! success "Approved"

    These principles have been approved by the DHCW TDA

## Introduction

These principles guide the design, development, delivery, and lifecycle
management of digital products and software. They operate within the framework
set by the overarching [Architecture Principles](architecture-principles.md)
and aim to ensure that our digital solutions are valuable, user-focused,
high-quality, sustainable, and aligned with strategic objectives.

---

## Deliver Measurable Value Continuously

Digital products and software must demonstrably meet user needs and
organisational strategic objectives. Development efforts should prioritise
features that deliver the highest value, released iteratively to enable rapid
feedback and adaptation.

??? info "Rationale"

    Focusing on continuous value delivery ensures that resources are applied
    effectively, benefits are realised sooner, and products evolve in line with
    changing requirements and priorities within the dynamic health and care
    landscape.

??? note "Implications"

    * Adopt agile and lean methodologies (e.g., Scrum, Kanban) for product
        development and delivery.
    * Define clear value propositions, key performance indicators (KPIs), and
        success metrics for all digital initiatives.
    * Prioritise backlogs based on value, risk, learning opportunities, and
        dependencies.
    * Embrace frequent, small, and incremental releases to gather feedback
        and deliver value early.
    * Establish robust feedback loops with users, clinicians, and
        stakeholders throughout the product lifecycle.
    * Product roadmaps are living documents, regularly reviewed and adjusted
        based on feedback and value realisation.

---

## User Needs Drive Product Evolution

The ongoing development and evolution of digital products must be guided by a
deep and empathetic understanding of user needs, behaviours, workflows, and
feedback within the specific context of health and care in Wales.

??? info "Rationale"

    While [User-Centred Design principles](user-centred-design.md)
    focus on the **how** of designing for users, this principle emphasises that
    **what** we build and how it evolves is continuously validated against real
    user requirements to ensure fitness for purpose and positive impact on
    health and care outcomes.

??? note "Implications"

    * Integrate user research (e.g., interviews, observations, surveys) and
        usability testing as continuous activities throughout the product
        lifecycle.
    * Develop and maintain clear user personas, user stories, and journey maps
        relevant to Welsh health and care pathways.
    * Utilise data analytics and user feedback mechanisms to understand user
        behaviour, identify pain points, and measure satisfaction.
    * Product backlogs and feature development are directly informed and
        prioritised by validated user needs and evidence from diverse user
        groups.
    * Ensure services are simple to use, accessible, and inclusive, meeting
        relevant standards and supporting both Welsh and English languages.
---

## Engineer for Quality, Resilience, and Maintainability

Software must be robust, secure, performant, and easy to maintain and evolve
over its lifecycle to ensure long-term viability, minimise technical debt, and
reduce the total cost of ownership, which is especially critical for systems
supporting health and care services.

??? info "Rationale"

    High-quality engineering practices lead to more reliable, secure, and
    adaptable systems that can better respond to future needs without excessive
    rework or risk.

??? note "Implications"

    * Adhere to approved coding standards, architectural patterns, and software
        development best practices.
    * Implement comprehensive and automated testing strategies, including unit,
        integration, contract, performance, and security testing.
    * Conduct regular, constructive code reviews and proactive refactoring to
        improve code quality and manage technical debt.
    * Design for modularity, loose coupling, and high cohesion to facilitate
        independent development, deployment, and scalability of components.
    * Embed security considerations throughout the software development
        lifecycle (DevSecOps), aligning with [Security & Identity principles](security-and-identity.md).
    * Apply rigorous clinical risk management throughout the software lifecycle
        for any product with potential clinical impact, adhering to relevant 
        clinical safety standards and regulatory requirements.
    * Ensure systems are designed for observability (comprehensive logging,
        monitoring, tracing, and alerting) to support operational stability and
        rapid issue resolution.
    * Strive for resource-efficient software design and implementation to
        minimise environmental impact, aligning with sustainability goals.
    * Document software architecture and design decisions clearly and keep 
        documentation up-to-date.

---

## Embrace Agile and DevOps Culture and Practices

Foster a collaborative, communicative, and continuously improving culture,
supported by DevOps practices, to enable rapid, reliable, and sustainable
delivery of high-quality digital products and software.

??? info "Rationale"

    An agile and DevOps approach breaks down silos, improves flow, automates
    processes, and empowers teams, leading to faster delivery cycles, higher
    quality, increased innovation, and better responsiveness to evolving needs.

??? note "Implications"

    * Promote the formation of empowered, cross-functional teams with shared
        ownership and accountability.
    * Implement robust CI/CD pipelines to automate build, testing, and
        deployment processes.
    * Encourage open communication, knowledge sharing, and collaborative
        problem-solving within and between teams.
    * Leverage endorsed collaboration tools and platforms to enhance teamwork
        and knowledge sharing, in alignment with [Digital Workplace principles](digital-workplace.md)
        where applicable.
    * Adopt "you build it, you run it" philosophies where appropriate, with
        teams taking responsibility for the operational support of their
        services.
    * Conduct regular retrospectives and experiments to continuously learn,
        adapt, and improve processes, tools, and team practices.
    * Champion psychological safety to encourage experimentation and learning
        from failures.

---

## Leverage Reusability and Promote Interoperability

Maximise efficiency, consistency, and integration capabilities by identifying,
creating, and utilising common components, services, platforms, and data
standards. Design systems to interoperate seamlessly within the ecosystem and
with authorised external systems.

??? info "Rationale"

    Reusability reduces duplication of effort, accelerates delivery, and lowers
    costs. Interoperability is fundamental for a connected health and care
    system, enabling data to flow securely and efficiently where it's needed.

??? note "Implications"

    * Prioritise the use of existing approved platforms, APIs, shared services,
        and common libraries.
    * Develop new components and services with reusability and clear interface
        contracts (e.g. APIs) in mind.
    * Adhere to established national and international interoperability
        standards relevant to health and care (e.g., HL7 FHIR, openEHR where
        appropriate).
    * Maintain and contribute to a catalogue of reusable assets, APIs, and data
        models.
    * Employ API-first design strategies to facilitate integration and enable a
        composable enterprise.
    * Ensure data is exchanged using agreed-upon formats and semantics,
        aligning with [Data & Analytics principles](data-and-analytics.md).

---

## Make Data-Informed Product and Technical Decisions

Product strategies, feature prioritisation, architectural choices, and
engineering improvements should be guided by objective data and evidence,
rather than solely by assumptions or opinions.

??? info "Rationale"

    Using data to inform decisions reduces risk, helps to validate hypotheses,
    optimises resource allocation, and ensures that efforts are focused on
    areas that will yield the most significant impact for users.

??? note "Implications"

    * Instrument applications and systems to collect relevant operational data,
        user analytics, and performance metrics.
    * Establish and monitor Key Performance Indicators (KPIs) and Service Level
        Objectives (SLOs) for digital products and services.
    * Regularly analyze collected data to identify trends, insights, user
        behaviours, system bottlenecks, and areas for improvement.
    * Utilize A/B testing, canary releases, and other experimentation
        techniques to validate changes and guide product evolution where
        appropriate.
    * Ensure that data used for decision-making is accurate, timely, and
        relevant, and that its collection and use comply with data privacy and
        governance policies.

---

## Manage Technology Pragmatically and Sustainably

Technology choices must be driven by fitness for purpose, long-term
sustainability, alignment with the strategic technology roadmap, security
requirements, and total cost of ownership, rather than by novelty or individual
preference.

??? info "Rationale"

    Pragmatic technology management ensures that we invest in solutions that
    are supportable, scalable, secure, and cost-effective over their intended
    lifespan, minimising risks associated with obsolescence or niche skill
    dependencies, and aligning with overarching [Architecture Principles](architecture-principles.md).

??? note "Implications"

    * Follow a "reuse before buy, buy before build" approach: prioritise
        reusing existing or publicly available solutions (including open source
        with appropriate support), then consider acquiring commercial
        off-the-shelf products, before commissioning new bespoke development, 
        as guided by [Architecture Principles](architecture-principles.md).
    * Evaluate technologies using clear criteria, including maturity,
        community/vendor support, security posture, scalability, performance,
        interoperability, skills availability, and alignment with existing
        technology stacks.
    * Favor proven technologies, open standards, and solutions that align with
        the [Cloud & Infrastructure principles](cloud-and-infrastructure.md).
    * Proactively manage technical debt: identify, prioritise, and address it
        systematically.
    * Consider the full lifecycle implications of technology choices, including
        development, deployment, operations, maintenance, and eventual
        decommissioning.
    * Maintain a clear technology radar and roadmap, regularly reviewing and
        updating it based on our evolving needs and the technology landscape.
    * Ensure that skills and knowledge for chosen technologies are developed
        and maintained.
