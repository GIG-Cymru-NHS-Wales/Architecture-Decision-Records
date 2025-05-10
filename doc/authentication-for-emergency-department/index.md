# Authentication for emergency department

!!! note
This is a work in progress (WIP) and a request for comments (RFC).

**Status**: Experiment by IGDC-DHCW + draft + work in progress + request for comments

**Date**: 2025-03-24

**Governance**: IGDC-DHCW for the time being

## Context

We are developing a hospital emergency department software application, and we
are learning that some kinds of authentication are not viable e.g. sending the
doctor an SMS text, or using a TOPT authenticator app on a nurse's mobile phone.

We welcome constructive advice, constructive criticism, pointers to resources,
and help.

Direct contact information:<br>
Joel Henderson <a href="mailto:joel.henderson@wales.nhs.uk">joel.henderson@wales.nhs.uk</a>

## Drivers

High-level drivers:

* We want multi-factor authentication because the data includes high-security
  healthcare records.

* We want usability and reliability because the clinical staff has so much
  things happening at once.

* We want speed because some emergency department patients have life-threatening
  critical issues.

Lower-level drivers:

* We intend to discover specific implementations for programming and for
  automatic testing.
  
* We intend to create explicit system quality attributes for usability,
  reliability, security, etc.

* We intend to launch a demo prototype open source example with test data within
  April 2025.
  
### Introductory reading

* [NHS England Digital: Guide to multi-factor authentication (MFA) policy](https://digital.nhs.uk/cyber-and-data-security/guidance-and-assurance/multi-factor-authentication-mfa-policy/guide-to-multi-factor-authentication-policy):
  This introduces the cyber security strategy for health and social care, the
  Cyber Assessment Framework (CAF), policy objectives and requirements, NHS
  smartcards, FIDO tokens, TOPT, federating with the NHS Care Identity Service
  2, and more.

* [GOV.UK: Using authenticators to protect an online service](https://www.gov.uk/government/publications/authentication-credentials-for-online-government-services):
  Good Practice Guide (GPG) 44 helps you choose the authenticator that will give
  you the right level of protection for your service.

* [What is the right authentication method for my medical device?](https://www.periculo.co.uk/cyber-security-blog/what-is-the-right-authentication-method-for-my-medical-device)

### Challenges

The hospital emergency department setting has challenges that are different than
in most settings.

For example, we're discovering challenges related to mobile phone
authentication, touchscreen interfaces, and multi-user authentication for
dangerous substances.

### Mobile phone authentication via text message and/or authenticator app

Generally, many worldwide programs use a person's mobile phone for
authentication, such as by sending the person a text message with a one-time use
code or one-time use link, or by prompting the person to open their
authenticator app and provide a one-time use code or one-time use password.

We cannot rely on every person having sufficient access to their personal
phones, however we may be able to use mobile phones as one option among others
for authentication.

* Some hospital administrators disallow personal phones for professional use.

* Some people have phones that are somewhat broken, such as with broken glass,
  which could introduce a safety risk in an emergency department setting.

* Some hospital staff store their personal phones in their work lockers, because
  they prefer to separate their personal life and professional life.

* Some triage staff do not want to expose their personal phones to any extra
  infection vectors, such as microbes in the emergency department.

* Some staff are reasonably concerned about accidentally damaging their phone,
  such as dropping it.

* Some healthcare professionals assert increased risk of microbial infection
  when consumer-grade phones are used in hospital-grade settings, because the
  phones cannot be easily wiped or disinfected.

* Some EHR representatives assert increased risk of accidents with personal
  mobile phones.

* Some providers do not want to carry their phones with them, because they are
  moving frequently among hospital areas that are dangerous for mobile phones,
  such as near MRI machines.

* Some hospitals have mobile coverage issues, because of subpar coverage by the
  local cellular company, or subpar coverage by the local wifi network, or
  signal interference by building structures or medical equipment.

* Some staff describe battery issues, such as their battery not lasting a full
  workday during normal use.

### Camera authentication

Generally, many mobile phones and desktop computers have cameras that can be
useful for authentication. A couple of popular examples are Apple iPhone FaceID
and Google Pixel Face Unlock.

We cannot rely on every person having sufficient access to cameras, however we
may be able to use cameras as one option among others for authentication.

* Example: A provider tries to use their personal mobile phone that has their
  installed EHR mobile app, which has a secure camera function. Unfortunately,
  the doctor accidentally uses the built-in camera app. This accidentally causes
  a PII leak (because the patient photo is now on the provider's personal photo
  stream) and additionally causes a loss of information (because the patient
  photo is not saved into the EHR).

* Example: A provider sees something about the patient and wants a second
  opinion from a peer or supervisor. The provider asks the patient ahead of time
  if it's OK to take a photo using the doctor's own personal phone camera, and
  explains to the patient that the purpose is to work around an EHR limitation
  in photo sharing. A typical example is a doctor who wants to get a second
  opinion from a colleague at a different health organization that uses a
  non-compatible EHR. This is all done fully transparently, and fully in the
  interests of helping the patient. However, the image never goes into either
  provider's EHR. Worse, some providers send the images via insecure messaging
  systems, or corporate social networks such as Facebook and WhatsApp.

* Example: A provider surreptitiously takes a photo for selfish reasons, such as
  photograhping a celebrity without their consent.

### Can we rely on fingerprint authentication?

No. We don't see any viable path forward for requiring fingerprints.

* Example: a provider wears nitrile gloves, which obscure fingerprints.

* Example: a provider gets their fingers wet, such as with body fluids, or with
  wash disinfectants.

### Can we rely on touchscreen interfaces?

Maybe. Probably yes if we try to use a medical-grade disinfectable large
touchscreen. Probably no if we try to use a personal phone.

* Example: A provider tries to use a touchscreen while wearing personal
  protective gear, such as latex gloves or nitrile gloves. Unfortunately, the
  gloves interfere with the touch screen. Additionally, the gloves may leave
  behind dust on the screen, which then interferes even more.

* Example: for shared touchscreens, such as those used in emergency departments,
  many providers touch the screen throughout the day. This can cause increased
  risk of cross-contamination, infection, microbial spread, and grime. In some
  medical settings, there are standard operating procedures for wiping screens
  and disinfecting screens, such as every hour, or between uses by each staff
  person, or between each patient interaction.

## Assessment - Considered Options

We aim to create good-enough security, good-enough speed, and good-enough
convenience.

We are currently investigating many options.

### Touchless chips

There are options for touchless chips, such as by using a touchless smartcard
(or wristband, or ring, etc.) that use radio-frequency identification (RFID)
and/or near field communication (NFC).

These can be used with many kinds of implementations, such as an RFID chip on a
physical ID card, or an NFC interaction by using a phone or smartwatch, etc.

### FIDO2, WebAuthn CTAP2

Newer protocols such as FIDO2 with WebAuthn and CTAP2 offer possibilities to go
passwordless. A FIDO2 security key looks like a promising path.

### Professional mobile phones

Could the hospital provide each staff member with a professional mobile phone?
This could be a highly-durable phone, with a drop-proof water-proof case, and
with hospital-specific multi-device management software.

There are expenses for this.

This option does not seem to address the problems with areas near MRI machines,
nor sub-par coverage.

### Touchscreen kiosks/devices

Could the hospital provide a medical-grade large touchscreen, such as 15-inch or
larger, such as on a medical cart?

There are commercial options for self-contained computers with medical-grade
large touchscreens, that have multiple large-capacity battery packs that can be
swapped in and out as needed, for 24-hour power without needing any wall outlet.

There are commercial options for rapid disinfectable screens, including with
dedicated physical buttons to lock the screen, so wiping the screen doesn't
accidentally cause any interface touch events.

### Two-person rule & two-person integrity

The two-person rule is a control mechanism designed to achieve a high level of
security for especially critical material or operations. Under this rule, access
and actions require the presence of two or more authorized people.

Two-person integrity (TPI) is the name for the security measures taken to
prevent single-person access.

In the context of healthcare, the two-person rule and two-person integrity can
be useful in a variety of ways.

* Example: When a clinician prescribes a highly-controlled substance, such as a
  medication that is risky or is known to be likely to be abused, then
  prescription requires a second clinician to sign it.

* Example When a clinician is treating a minor, then the clinician must have a
  second-in-command clinician present and also concurring with the treatment.

### Microsoft Windows Hello

Microsoft Windows Hello is "a more personal way to sign in, using your face,
fingerprint or a PIN. You can use Windows Hello to sign in to your device from
the lock screen and sign in to your account on the web."

There are some issues with face recognition if the provider is wearing a face
mask. These issues may be simple or complex to overcome, depending on whether
the software is able to do a sufficiently-expert recognition of the person's eye
area and 3D facial structure.

There may be some issues with how many different people can use one Microsoft
Windows Hello sign in, on some devices. One of our security consulting partners
has said that they hit limits at 10 users of the same machine.

We believe there are similar kinds of camera-based authentication systems for
other operating systems and devices. A common request is to ensure that whatever
system we develop is also conceptually viable to work on a typical iPad and a
typical Android tablet.

### Biometric sign in beyond face and fingerprints

There are potential options for biometric sign in beyond face and fingerprints:
voice recognition, hand recognition, retina recognition. We may research these.

## Recommendation - Decision Outcome

TODO after we gather options.

{Describe the chosen option and justification}.

### Consequences (Optional)

TODO after we gather options.

* Good, because {positive consequence, e.g., improvement of one or more desired qualities, …}

* Bad, because {negative consequence, e.g., compromising one or more desired qualities, …}

* … <!-- numbers of consequences can vary -->

### Confirmation (Optional)

TODO after we gather options.

{Describe how the implementation of/compliance with the ADR can/will be confirmed.}

## Pros and Cons of the Options (Optional)

TODO after we gather options.

### {title of option 1}

TODO after we gather options.

<!-- This is an optional element. Feel free to remove. -->
{example | description | pointer to more information | …}

* Good, because {argument a}
* Good, because {argument b}
<!-- use "neutral" if the given argument weights neither for good nor bad -->
* Neutral, because {argument c}
* Bad, because {argument d}
* … <!-- numbers of pros and cons can vary -->

## More Information (Optional)

TODO after we gather options.

{You might want to provide additional evidence/confidence for the decision
outcome here and/or document the team agreement on the decision and/or define
when/how this decision the decision should be realised and if/when it should be
re-visited. Links to other decisions and resources might appear here as well.}
