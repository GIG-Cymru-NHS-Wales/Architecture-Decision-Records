# Software design development guidance

!!! note
    Work in Progress

**Status**: first sketch, work in progress, request for collaboration

**Date**: Updated 2025-04-01

**Governance**: To Be Discovered; potentially a combo of this repo participants, DHCW CISO, NHS Wales UCB peers, etc.

## Situation - Context and Problem Statement

Broadly we need to design and develop many software products for patients and healthcare workers, and we want our design and development to emphasize usability, accessibility, maintainability, and similar system quality attributes.

Narrowly we need to immediately design and develop the emergency department module, and we need to give the program some UI/UX guardrails:

* Design system: e.g. how should a top navigation menu look and feel to the user.

* Development system: e.g. how should a programmer implement the menu with JavaScript/TypeScript.

* Testing system: e.g. how to test the menu for accessibility, multi-language capability, etc.

## Background - Decision Drivers

We want to get good-enough quality work in place now, so we can try it out, ask for feedback, and seek help from peers and advisors.

We want to align with existing design-development recommends, not reinvent the wheel.

We generally favor considering systems that we are confident are relevant and ready:

* Government guidelines: GOV.UK Design System, NHS.UK Design System, 18F Design System, others?

* Business specifications: Apple Human Interfaces Guidelines, Google Material Design, Microsoft Fluent Design System, others?

* Free open source components using JavaScript and TypeScript: shadcn, Flowbite, SkeletonUI, others?

We want to use accessibility:

* [Web Content Accessibility Guidelines (WCAG) 2.2](https://www.w3.org/TR/WCAG22/) including must-have minimum level A, should-have medium level AA, could-have maximum level AAA.

## Assessment - Considered Options

We generally favor considering systems that we are confident are relevant and ready:

[Introductory summaries are by Wix](https://www.wix.com/studio/blog/design-system-examples)

Government guideline options:

* [GOV.UK Design System](https://design-system.service.gov.uk/)

* [GOV.UK Prototype Kit](https://prototype-kit.service.gov.uk/)

* [NHS.UK: Design system](https://service-manual.nhs.uk/design-system)

* [UK Office of National Statistics (ONS) Design System](https://service-manual.ons.gov.uk/design-system)

* [18F.gov: The U.S. Web Design System ](https://guides.18f.gov/ux-guide/design/use-a-design-system/)

Business specifications options:

* [Apple Human Interface Guidelines (HIG)](https://developer.apple.com/design/human-interface-guidelines)

* [Google Material Design 3](https://m3.material.io/)

* [Microsoft Fluent 2 Design System](https://fluent2.microsoft.design/)

* [IBM Carbon Design System](https://carbondesignsystem.com/)

* Gitlab Pajamas

* [Wix Studio Design System](https://www.wix.com/studio/blog/design-system-examples)

* Salesforce Lightning Design System

* Atlassian Design System

* Adobe Spectrum

* Mailchimp Design System

* ETrade Design Language

* Uber Design System

* The Guardian Digital Design System

* SAP Fiori for Web

Component frameworks:

* [shadch: build your component library](https://ui.shadcn.com/)

* [Flowbite: Build websites even faster with components](https://flowbite.com/)

* [SkeletonUI adaptive design system](https://www.skeleton.dev/)


### Government guideline: GOV.UK Design System

[GOV.UK Design System](https://design-system.service.gov.uk/)

TODO

### Government guideline: GOV.UK Prototype Kit

[GOV.UK Prototype Kit](https://prototype-kit.service.gov.uk/)

[Our ADR assessment: unfit because it's poorly maintained](gov-uk-prototype-kit/)

### Government guideline: NHS.UK Design System

[NHS.UK: Design system](https://service-manual.nhs.uk/design-system)

TODO

### Government guideline: UK Office of National Statistics (ONS) Design System

[UK Office of National Statistics (ONS) Design System](https://service-manual.ons.gov.uk/design-system)

TODO


### Government guideline: 18F Design System

[18F.gov: The U.S. Web Design System ](https://guides.18f.gov/ux-guide/design/use-a-design-system/)

TODO

### Business specifications: Apple Human Interfaces Guidelines

[Apple Human Interface Guidelines (HIG)](https://developer.apple.com/design/human-interface-guidelines)

Apple’s Human Interface Guidelines are for those who design, develop and distribute apps through Apple’s platforms (macOS, iOS, watchOS, tvOS and visionOS). The brand has additional guidelines organized by tech vertical, covering 28 additional branded elements such as CarPlay, HomeKit, Augmented Reality, iCloud and Wallet.

Under each platform, you can find guidance on app architecture, user interaction, system capabilities and visual design. Each section offers in-depth guidance on the intended use of each interface element and the rationale behind it. The goal is to ensure that apps offered through Apple’s platforms feel familiar and consistent to people who use them.

There’s also an extensive resource library with Sketch, Photoshop and Adobe XD files, which house a range of UI elements and specifications. You can also watch video sessions and tutorials on how to build intuitive, user-friendly experiences.

### Business specifications: Google Material Design

[Google Material Design 3](https://m3.material.io/)

Going on a decade strong, Material Design has inspired many other companies to adopt their own design systems. It builds upon the metaphor of material, meaning that components are created to mimic the physical world and its textures (such as how objects reflect light and cast shadows). The idea is that when components behave like real-world objects, they become more familiar and predictable, which in turn reduces cognitive load for users.

Material Design is comprehensive and covers an array of topics ranging from design principles like color, typography, and iconography, to UI components–many of which are available as open source–to code documentation and other resources.

In 2018, Google introduced Material Theming, which extends Material Design principles to other brands, allowing designers to style components according to their brand’s needs. It added much-needed flexibility to the system, by offering ways to customize a single set of components. A series of hypothetical case studies, called Material Studies, demonstrate how components can be styled to fit any product, ranging from a finance app to an eCommerce app.

### Business specifications: Microsoft Fluent Design System

[Microsoft Fluent 2 Design System](https://fluent2.microsoft.design/)

First developed in 2017, Fluent is a collection of UX frameworks and UI components that share code, a unified design approach and a consistent set of interaction behaviors. The design system helps build coherent experiences across platforms, including web, Windows, iOS, Android and macOS. Last year, Microsoft announced Fluent 2, touted as the next evolution of the design system which enables more seamless collaboration and creativity.

Fluent 2 highlights five sensory elements (light, depth, motion, material and scale) using the physical world as its vocabulary. By taking inspiration from the physical world, Fluent guides the creation of experiences that feel as natural as possible. This can extend across devices that people use throughout their day (like tablet and mobile), plus experiences that are designed beyond a flat screen (such as mixed reality interfaces).

Fluent is an open source design system. It’s connected to a LinkedIn group where customers, partners, and a community of designers and developers can submit feedback to help improve the system.

### Business specifications: IBM Carbon Design System

[IBM Carbon Design System](https://carbondesignsystem.com/)

The IBM Carbon Design System is an open-source system for all of IBM’s digital products. The system consists of human-interface guidelines, working code, and design resources, and is connected to a community of contributors. It aims to improve UI consistency and quality through clear, discoverable guidance around design and development best practices.

The design system emphasizes its open-source nature by providing standards and documentation on how to contribute components and patterns, report issues or provide general feedback through its GitHub community.

The Carbon design system has a counterpart, the IBM Design Language, which focuses on the company’s design philosophy, design principles and its visual language guidelines.

### Business specifications: GitLab Pajamas

GitLab is a repository manager which lets teams collaborate on code. It’s an open core product (meaning its a software that combines aspects of both open and closed source models), with over 2,000 community contributors. The Pajamas design system ensures GitLab’s contributors are provided with the resources and know-how for contributing to the system. It includes detailed documentation on how to submit UX proposals, feature proposals and enhanced code implementations.

There’s even a section on community-based UX research contributions, accompanied by a UX Research Handbook and training resources for those who want to contribute.

The design elements in this system are very clearly organized and follow an atomic design approach, as they’re labeled components, regions and objects. This method, developed by Brad Frost in his book Atomic Design, emphasizes a modular approach in combining elements such as basic UI components to create increasingly more complex objects, such as an entire page.

### Business specifications: Wix Studio Design System

Wix Studio's Design System offers a comprehensive toolkit for developers and designers to craft beautiful and intuitive product experiences. We use it to create our website pages and Wix Studio applications.

The Wix Studio Design System offers: a library with core UI components, various sets of design patterns for use in different contexts, a Figma kit with components, icons and ready-to-use page templates, detailed component documentation including demos and props reference, a sub-brand for developers with the same DNA but a different vibe, an interactive playground for hands-on exploration, and more.

For developers, the Wix Studio Design System includes a React library of core reusable components. This library streamlines the rapid prototyping and development of Wix-styled applications. For designers, the Wix Studio Design System includes a Figma kit to integrate Wix Studio design assets into their design workflow. This kit fosters enhanced collaboration and iteration throughout the design process, simplifies cooperation with developers, and ensures adherence to Wix Studio's visual standards.

### Business specifications: Salesforce Lightning Design System

Created nearly ten years ago, the Salesforce Lightning Design System is an excellent example of a design system that’s evolved over time. SLDS establishes principles and best practices for designing enterprise applications across the Salesforce ecosystem. Rather than focusing on pixels, it allows designers to focus on user experience, interactions, and flows, and helps developers focus on application logic.

Salesforce also pioneered the use of design tokens, which store visual design attributes (e.g., color, font size, spacing) that can be applied and updated across components and platforms. Rather than hard-coding individual values as visual designs evolve, design tokens ensure that changes are reflected across the entire product experience. They allow for a consistent visual system that's also much simpler to scale.

### Business specifications: Atlassian Design System

Atlassian recently introduced their new design system, which is a combination of two older sites (Atlassian Design Guidelines and Atlaskit). Prior to introducing the new system, Atlassian’s design guidelines and code documentation were hosted on separate sites, which led to growing inconsistencies that reflected a design and code split.

With the new design system, Atlassian weaves content and code together from both sites so that designers, developers, and content designers have a unified destination to update, contribute to, and build upon. The new design system includes a section on brand mission, personality, values and brand promise. It also lays out guidelines for foundations, components, patterns, content and resources to help simplify the creation process.

### Business specifications: Adobe Spectrum

Available to the public since 2019, Spectrum defines a common experience across Adobe’s family of applications. A driving force for Spectrum is that once you learn one Adobe tool, you can easily pick up a second one and know how to navigate its UI to get things done. The system also helps ensure a consistent experience across platforms, such that if you begin a project on your iPad, you can finish it on your desktop or phone.

Adobe’s design system also has a plugin for XD that provides instant access to Spectrum, which draws components dynamically based on a design token system. The plugin lets you explore all the variants and properties of a given component, with direct access to its documentation. Stay on the lookout for Spectrum 2, the next iteration of Adobe’s design system set to launch some time this year.

### Business specifications: Mailchimp Design System

Mailchimp is a marketing automation platform and email marketing service. In 2018, Mailchimp updated their brand to feel bolder and more expressive, through winking humor and playful illustrations. Their design system also takes on this colorful identity.

Their design system consists of two sections: foundations and components. It has an impressive data visualization section, offering detailed guidance on how to tell a clear and compelling data story. The guidelines include color groupings that are optimized for visual harmony, consistency, predictability and accessibility. It also provides guidance on how color, shapes, and spacing can be used to communicate data in a way that’s clear and on-brand.

### Business specifications: ETrade Design Language

ETrade is an online brokerage firm that also offers a range of financial services. The ETrade design language aims to create an excellent user experience, by ensuring front-end consistency and accessibility across ETrade’s websites and applications. The system consists of foundations, components, patterns and resources, with emphasis on design for the web. Each component displays different variations and states, interactive demos, code snippets, and usage guidelines that include examples of correct and incorrect usage.

The design system also has an extensive set of UX writing guidelines, which aim to keep voice, tone, and messaging standards in check, while maintaining brand personality. This section includes principles, accessibility guidelines, grammar, punctuation and examples of how writing should be structured within different web elements.

### Business specifications: Uber Design System

Uber’s design system covers nine main elements: logo, color, composition, iconography, illustration, motion, photography, tone of voice and typography. The company takes pride in the system’s flexibility and ease-of-use, maintaining brand consistency across various sub-brands, applications and assets.

In addition to their visual and style guidelines, Uber’s also created Base Web, an open-source library of UI components that focus on the basics (hence the name, “Base”), such as typography, color, grid and iconography, as well as essential elements like buttons, lists and controls. While these components are designed as basic building blocks, they’re also highly customizable through style overrides and can be configured in many different ways.

### Business specifications: The Guardian Digital Design System

The Guardian digital design system is a visually stunning set of guidelines that you can scroll through page-by-page. It starts with a high-level overview of what a webpage consists of, followed by more granular elements such as fronts, containers, cards and articles.

Within the card pages, for example, you can see the different options available for card sizes and card types. The design system also demonstrates how the design team treats color, typography, layout, rules and spacing.

### Business specifications: SAP Fiori for Web

SAP (Systems, Applications and Processing) is an enterprise software applications provider that helps businesses of all sizes run better. The company’s software acts as a centralized system that allows departments to access and share data, and at the heart of these different software is the SAP Fiori for Web design system.

Built with the company’s SAPUI5 framework, which is a collection of user interfaces for web apps, the company places an emphasis on designing for common components, including navigational elements, tables and user inputs. Big picture, the brand includes guidelines for general principles, using layouts, patterns and controls, as well as concrete guidance to execute a user-centered approach to designing SAP Fiori apps.

### Component framework: shadcn

[shadch: build your component library](https://ui.shadcn.com/)

TODO

### Component framework: Flowbite

[Flowbite: Build websites even faster with components](https://flowbite.com/)

TODO

### Component framework: SkeletonUI

[SkeletonUI adaptive design system](https://www.skeleton.dev/)

TODO

## Evaluations - Opinions

[Compare capabilities - TSV table - please update this as we learn more](compare-capabilities.tsv)

{{ read_table('./compare-capabilities.tsv', sep = '\t') }}

[Compare components - TSV table - please update this as we learn more](compare-components.tsv)

{{ read_table('./compare-components.tsv', sep = '\t') }}

### By Joel

What I see in GOV.UK:

* Pros: the principles are excellent, and expressed clear ways, and with good examples.

* Cons: the implementation technology is Mozilla Nunjucks, which is quite outdated by multiple years, and doesn't lead with modern JavaScript practices such as ESM, and seems to have no obvious way to upgrade the whole project to ESM.

As far as I can tell, GOV.UK is the original starting point for the NHS UK digital service manual design system and the UK Office of National Statistics (ONS) Design System.

What good looks like to me for origin-derivation design systems:

* The origin system (i.e. GOV.UK) would have some kind of child list, such as a section that explains "Here are design systems that we know about that are derived from GOV.UK and how they compare."

* The derivation design systems (i.e. NHS UK, ONS UK) would each have a section that explains "This design system starts with from GOV.UK, then we change these X items because Y".

I haven't yet found derivation explanations.

* What good looks like to me here, ideally, is figuring out what/how NHS UK derived from GOV UK, and why the NHS UK team didn't/couldn't send upstream changes. In other words, I haven't found an explanation yet of what makes the NHS UK design system incompatible with the GOV UK design system.

* As far as I can tell, the GOV.UK derivations shouldn't need to exist, and I mean this in a good way. For example, everything I see in derivations looks prima facie great for all of the UK, and great for upstreaming to GOV UK. I haven't yet found an explanation of why the derivations haven't upstreamed.

Ideally someone on our UI/UX team will do a derivation comparison with these, because they seem to be quite similar yet incompatible.

* Until we know more, the safest choice is the original, because it is the most-general, and the easiest to make more-specific later on if we want to use any of the derivations.

* My educated guess is that there's good work to do here, unifying all three of the UK systems that we know about.

## Recommendation - Decision Outcome

Given what we know so far, and the immediacy of the emergency department module, we are immediately pursuing the combination of one choice in each category that we believe will keep the most options open for our ongoing improvements and learning. In other words, we need to kickstart real work, and we know that what we learn about our needs may well alter our longer-term choices.

* Government guidelines: We are kickstarting with GOV.UK because these guidelines are good enough for now, and definitely intended for all of the UK (including Wales), and we don't need to cut out anything that NHS England might have added that's specific to England.

* Business specifications: We are kickstarting with Apple Human Interface Guidelines: because these orient more toward high-level principles (especially usability and accessibility), rather than low-level rendering (such as colors, fonts, grids).

* Component framework: We are kickstarting shadcn because it is free open source, widespread worldwide, has implementations in JavaScript and TypeScript, and has multiple tunings for specific development frameworks, which in turn improves maintainability and testability.

Ways of working:

* We start now, and we do continuous improvement as we learn more about the real work.

* We understand that all of these options are significantly ahead of NHS Wales DHCW can design and develop internally, because we are resourced constrained.

* We believe that any combination of the above options will be better than none, so we're using the principles of 1) bias for action, 2) don't let perfect be the enemy of the good, 3) ship soon then improve, 4) helping the emergency department staff and getting their direct feedback is a higher priority than any specific pre-planning of colors, fonts, logos, layouts, etc.

## Consequences

Positive Consequences:

* Consistency: Using a unified design system will ensure a consistent experience across different platforms and applications, improving user familiarity.

* Accessibility: By following established government and business guidelines, the design will ensure accessibility is prioritized, making the system usable by all.

* Maintainability: TypeScript’s static typing ensures fewer runtime errors, and a strong component-based system built with Shadcn offers long-term scalability and ease of updates.

* Flexibility: Shadcn customization options make it adaptable to different design languages, allowing for seamless integration with NHS, GOV.UK, or Material design.

Negative Consequences:

* Initial Complexity: Merging different design guidelines may initially increase the complexity of the design process.

* Overhead: TypeScript requires developers to be proficient in it, and its setup can be more time-consuming compared to JavaScript.

* Performance: While Shadcn and Flowbite are generally efficient, they may introduce more runtime overhead compared to lightweight frameworks like SkeletonUI, particularly for very minimal or extremely-performance-sensitive applications.
