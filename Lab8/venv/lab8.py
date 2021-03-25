from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import create_engine, Table,Column, String, Integer, MetaData
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

engine = create_engine("sqlite:///people.db", echo=True)
Base = declarative_base()
meta = MetaData()

Session = sessionmaker(bind=engine)
session = Session()

class Osoba(Base):

    __tablename__ = 'osoba'

    id = Column(Integer(), primary_key=True, nullable=False)
    imie = Column(String())
    nazwisko = Column(String())
    ulica = Column(String())
    miejscowosc = Column(String())
    kod_pocztowy = Column(String())
    adres_email = Column(String())
    numer_telefonu = Column(String())
    id_innej_osoby = Column(Integer())

    def __init__(self, id, imie, nazwisko, ulica, miejscowosc, kod_pocztowy, adres_email, numer_telefonu, id_innej_osoby):
        self.id=id
        self.imie=imie
        self.nazwisko=nazwisko
        self.ulica=ulica
        self.miejscowosc=miejscowosc
        self.kod_pocztowy=kod_pocztowy
        self.adres_email=adres_email
        self.numer_telefonu=numer_telefonu
        self.id_innej_osoby=id_innej_osoby

def Print(Osoba):
    print('id= '+str(Osoba.id)+' imie='+Osoba.imie+ ' nazwisko='+Osoba.nazwisko+
          ' adres='+Osoba.ulica+' '+Osoba.miejscowosc+' '+Osoba.kod_pocztowy+
          ' adres email='+Osoba.adres_email+' numer telefonu='+Osoba.numer_telefonu
          + ' id_innej_osoby='+str(Osoba.id_innej_osoby))

def dodaj_osobe(id,imie, nazwisko, ulica,miejscowosc, kod_pocztowy, adres_email, numer_telefonu, id_innej_osoby):
    os = Osoba(id,imie, nazwisko, ulica,miejscowosc, kod_pocztowy, adres_email, numer_telefonu, id_innej_osoby)
    session.add(os)
    session.commit()

def znajdz_dzieki_imieniu(imie):
    i=0
    for s in session.query(Osoba).filter(Osoba.imie == imie):
        Print(s)
        i+=1
    if i==0:
        print("Nie ma osoby o takim imieniu")


def znajdz_dzieki_nazwisku(nazwisko):
    i=0
    for s in session.query(Osoba).filter(Osoba.nazwisko == nazwisko):
        Print(s)
        i += 1
    if i == 0:
        print("Nie ma osoby o takim nazwisku")


def znajdz_dzieki_imieniu_nazwisku(imie, nazwisko):
    i = 0
    for s in (session.query(Osoba).filter(Osoba.imie == imie)):
        if s.nazwisko == nazwisko:
            Print(s)
            i += 1
    if i == 0:
        print("Nie ma osoby o takim imieniu i nazwisku")

def usun_po_imieniu_nazwisku(imie, nazwisko):
    i=0
    for s in (session.query(Osoba).filter(Osoba.imie == imie)):
        if s.nazwisko == nazwisko:
            session.delete(s)
            i+=1
    if i==0:
        print("Nie było osoby o takim imieniu i nazwisku")
    session.commit()


if __name__ == '__main__':
    Base.metadata.create_all(engine)
    dodaj_osobe(id=14,imie='qqq',nazwisko='qqqq',ulica='ulica 11', miejscowosc="miejscowosc", kod_pocztowy="00-000",adres_email='aaaaa@aa.com',numer_telefonu='111111111, 22222',id_innej_osoby=None)
    dodaj_osobe(12,'bbb','bbbb','ul 1','mjsc','00-001','bbbbb@bb.com','1, 2, 3',1)
    dodaj_osobe(13, 'bbb', 'qqqq', 'ul 1', 'mjsc', '00-001', 'bbbbb@bb.com', '1, 2, 3', 1)

    print("Szukanie po imieniu:")
    znajdz_dzieki_imieniu('bbb')
    print("Szukanie po nazwisku:")
    znajdz_dzieki_nazwisku('qqqq')
    print("Szukanie po imieniu i nazwisku:")
    znajdz_dzieki_imieniu_nazwisku('bbb','qqqq')

    print('\n\n\n\nTestowanie usuwania')
    znajdz_dzieki_imieniu_nazwisku('qqq', 'qqqq')
    print('\n\n')
    usun_po_imieniu_nazwisku('qqq', 'qqqq')
    print('\n\n')
    znajdz_dzieki_imieniu_nazwisku('qqq', 'qqqq')

    print('\n\n\n\nTestowanie usuwania nieistniejacej osoby')
    usun_po_imieniu_nazwisku('www', 'qqqq')
    print("koniec")