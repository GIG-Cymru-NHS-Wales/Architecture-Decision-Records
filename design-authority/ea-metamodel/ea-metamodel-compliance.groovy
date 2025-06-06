def validReferences = [
  ['Business Capability', 'Is Realized By', 'Application'],
  ['Business Capability', 'ardoq_parent', 'Business Capability'],
  ['Technical Capability', 'Is Realized By', 'Application'],
  ['Technical Capability', 'ardoq_parent', 'Technical Capability'],
  //
  ['Person', 'Is Expert In', 'Application'],
  ['Person', 'Is Expert In', 'Business Capability'],
  ['Person', 'Owns', 'Application'],
  //
  ['Organizational Unit', 'Consumes', 'Application'],
  ['Organizational Unit', 'Consumes', 'Application Module'],
  ['Organizational Unit', 'Supplies', 'Application'],
  ['Organizational Unit', 'Supports', 'Application'],
  ['Organizational Unit', 'Owns', 'Application'],
  ['Organizational Unit', 'ardoq_parent', 'Organization'],
  ['Organizational Unit', 'ardoq_parent', 'Organizational Unit'],
  ['Organizational Unit', 'Partners With', 'Organizational Unit'],
  //
  ['Application Module', 'ardoq_parent', 'Application'],
  ['Application', 'ardoq_parent', 'Application'],
  ['Application', 'ardoq_parent', 'Application Group'],
  ['Application', 'Has Successor', 'Application'],
  ['Application', 'Connects To', 'Application'],
  ['Application', 'Depends On', 'Application'],
  ['Interface', 'ardoq_parent', 'Application'],
  ['Interface', 'Connects To', 'Application']
]

def isLegalReference = {
  project('sourceType', 'type', 'targetType').
    by(outV().label()).
    by(label()).
    by(inV().label()).
  filter{
    validReferences.any{ validReference ->
      validReference[0] == it.get()['sourceType'] &&
      validReference[1] == it.get()['type'] &&
      validReference[2] == it.get()['targetType']
    }
  }
}

g.V().
  hasLabel('Application', 'Business Capability', 'Person', 'Organizational Unit').
  bothE().
  dedup().
  not(isLegalReference()).
  project('source', 'source type', 'reference', 'target', 'targetType type').
    by(outV().values('name')).
    by(outV().label()).
    by(label()).
    by(inV().values('name')).
    by(inV().label())