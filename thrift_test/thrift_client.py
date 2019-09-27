# coding=utf-8

import os
import sys

sys.path.append(os.path.abspath(os.path.join(os.path.dirname('__file__'), os.path.pardir)))

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol
from test.PersonService import Client
from test.PersonService import Person

__HOST = 'localhost'
__PORT = 8899

try:
    tsocket = TSocket.TSocket(__HOST, __PORT)
    transport = TTransport.TFramedTransport(tsocket)
    protocol = TCompactProtocol.TCompactProtocol(transport)
    client = Client(protocol)
    transport.open()
    data = Person("list")
    print('client-requets')
    res = client.getPersonByUsername("lisi")
    print('server-answer', res)

    transport.close()
except Thrift.TException as ex:
    print(ex.message)
