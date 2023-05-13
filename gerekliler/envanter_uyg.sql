CREATE DATABASE envanter;
USE envanter;

CREATE TABLE sehir_bilgi (
  sehir_id VARCHAR(45) NOT NULL,
  sehir_isim VARCHAR(45) NOT NULL,
  PRIMARY KEY (sehir_id));
  
CREATE TABLE depo_bilgi (
  depo_id VARCHAR(45) NOT NULL,
  isim VARCHAR(45) NOT NULL,
  sehir_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (depo_id),
CONSTRAINT fk_sehir_id
FOREIGN KEY (sehir_id)
REFERENCES sehir_bilgi(sehir_id));
  
CREATE TABLE urun_bilgi (
  urun_id INT NOT NULL,
  isim VARCHAR(45) NOT NULL,
  fiyat INT NOT NULL,
  stok_bilgi INT NOT NULL,
  depo_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (urun_id),
   CONSTRAINT fk_depo_id
FOREIGN KEY (depo_id)
REFERENCES depo_bilgi(depo_id));

CREATE TABLE satici (
  satici_id INT NOT NULL AUTO_INCREMENT,
  satici_ad VARCHAR(45) NOT NULL,
  telefon_no VARCHAR(45) NOT NULL,
  e_posta VARCHAR(45) NOT NULL,
  adres VARCHAR(45) NOT NULL,
  sehir_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (satici_id),
  CONSTRAINT fk_sehir_id2
FOREIGN KEY (sehir_id)
REFERENCES sehir_bilgi(sehir_id));

CREATE TABLE musteri_bilgi (
  musteri_id INT NOT NULL AUTO_INCREMENT,
  musteri_ad VARCHAR(45) NOT NULL,
  telefon_no VARCHAR(45) NOT NULL,
  e_posta VARCHAR(45) NOT NULL,
  adres VARCHAR(45) NOT NULL,
  sehir_id VARCHAR(45) NOT NULL,
  PRIMARY KEY (musteri_id),
  CONSTRAINT fk_sehir_id1
FOREIGN KEY (sehir_id)
REFERENCES sehir_bilgi(sehir_id));


CREATE TABLE satis_bilgi (
  satis_id INT NOT NULL AUTO_INCREMENT,
  musteri_id INT NOT NULL,
  urun_id INT NOT NULL,
  alis_sekli VARCHAR(45) NOT NULL,
   urun_adet INT NOT NULL,
  PRIMARY KEY (satis_id),
  CONSTRAINT fk_urun_id
FOREIGN KEY (urun_id)
REFERENCES urun_bilgi(urun_id),
CONSTRAINT fk_musteri_id
FOREIGN KEY (musteri_id)
REFERENCES musteri_bilgi(musteri_id));
  
CREATE TABLE alis_bilgi (
  alis_id INT NOT NULL AUTO_INCREMENT,
  satici_id INT NOT NULL,
  urun_id INT NOT NULL,
  urun_adet INT NOT NULL,
  PRIMARY KEY (alis_id),
  CONSTRAINT fk_urun_id1
    FOREIGN KEY (urun_id)
    REFERENCES urun_bilgi(urun_id),
  CONSTRAINT fk_satici_id1
    FOREIGN KEY (satici_id)
    REFERENCES satici(satici_id)
);


CREATE TRIGGER insert_alis_bilgi
AFTER INSERT ON alis_bilgi
FOR EACH ROW
UPDATE urun_bilgi
SET stok_bilgi = stok_bilgi + NEW.urun_adet
WHERE urun_id = NEW.urun_id;

CREATE TRIGGER update_alis_bilgi
AFTER UPDATE ON alis_bilgi
FOR EACH ROW
UPDATE urun_bilgi
SET stok_bilgi = stok_bilgi - (OLD.urun_adet - NEW.urun_adet)
WHERE urun_id = NEW.urun_id;

CREATE TRIGGER insert_stok_bilgi_on_satis
AFTER INSERT ON satis_bilgi
FOR EACH ROW
UPDATE urun_bilgi
SET stok_bilgi = stok_bilgi - NEW.urun_adet
WHERE urun_id = NEW.urun_id;

CREATE TRIGGER update_stok_bilgi_on_satis
AFTER UPDATE ON satis_bilgi
FOR EACH ROW
UPDATE urun_bilgi
SET stok_bilgi = stok_bilgi + OLD.urun_adet - NEW.urun_adet
WHERE urun_id = NEW.urun_id;

DELIMITER //

CREATE TRIGGER before_insert_satis_bilgi
BEFORE INSERT ON satis_bilgi
FOR EACH ROW
BEGIN
    DECLARE stok INT;
    SELECT stok_bilgi INTO stok FROM urun_bilgi WHERE urun_id = NEW.urun_id;
    IF stok < NEW.urun_adet THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Stokta yeterli ürün bulunmamaktadır!';
    END IF;
END//

DELIMITER ;

CREATE INDEX idx_urun_id ON satis_bilgi (urun_id);
CREATE INDEX idx_sehir_id ON depo_bilgi (sehir_id);
CREATE INDEX idx_depo_id ON urun_bilgi (depo_id);

CREATE VIEW tedarikcilerin_urunleri AS
SELECT (SELECT satici_ad FROM satici WHERE satici_id = alis_bilgi.satici_id) AS satici_ad,
       urun_bilgi.isim AS urun_ismi, 
       urun_bilgi.fiyat
FROM alis_bilgi
INNER JOIN urun_bilgi ON alis_bilgi.urun_id = urun_bilgi.urun_id;


CREATE VIEW musteri_sayisi AS
SELECT m.sehir_id, COUNT(*) AS musteri_sayisi
FROM musteri_bilgi m
GROUP BY m.sehir_id;


CREATE VIEW depo_urunleri AS
SELECT d.depo_id, u.urun_id, u.isim AS urun_isim
FROM depo_bilgi d
INNER JOIN urun_bilgi u ON d.depo_id = u.depo_id;


/*Sehir Bilgileri*/
INSERT INTO sehir_bilgi (sehir_id, sehir_isim) VALUES
('1', 'Adana'),
('2', 'Adıyaman'),
('3', 'Afyon'),
('4', 'Ağrı'),
('5', 'Amasya'),
('6', 'Ankara'),
('7', 'Antalya'),
('8', 'Artvin'),
('9', 'Aydın'),
('10', 'Balıkesir'),
('11', 'Bilecik'),
('12', 'Bingöl'),
('13', 'Bitlis'),
('14', 'Bolu'),
('15', 'Burdur'),
('16', 'Bursa'),
('17', 'Çanakkale'),
('18', 'Çankırı'),
('19', 'Çorum'),
('20', 'Denizli'),
('21', 'Diyarbakır'),
('22', 'Edirne'),
('23', 'Elazığ'),
('24', 'Erzincan'),
('25', 'Erzurum'),
('26', 'Eskişehir'),
('27', 'Gaziantep'),
('28', 'Giresun'),
('29', 'Gümüşhane'),
('30', 'Hakkari'),
('31', 'Hatay'),
('32', 'Isparta'),
('33', 'Mersin'),
('34', 'İstanbul'),
('35', 'İzmir'),
('36', 'Kars'),
('37', 'Kastamonu'),
('38', 'Kayseri'),
('39', 'Kırklareli'),
('40', 'Kırşehir'),
('41', 'Kocaeli'),
('42', 'Konya'),
('43', 'Kütahya'),
('44', 'Malatya'),
('45', 'Manisa'),
('46', 'Kahramanmaraş'),
('47', 'Mardin'),
('48', 'Muğla'),
('49', 'Muş'),
('50', 'Nevşehir'),
('51', 'Niğde'),
('52', 'Ordu'),
('53', 'Rize'),
('54', 'Sakarya'),
('55', 'Samsun'),
('56', 'Siirt'),
('57', 'Sinop'),
('58', 'Sivas'),
('59', 'Tekirdağ'),
('60', 'Tokat'),
('61', 'Trabzon'),
('62', 'Tunceli'),
('63', 'Şanlıurfa'),
('64', 'Uşak'),
('65', 'Van'),
('66', 'Yozgat'),
('67', 'Zonguldak'),
('68', 'Aksaray'),
('69', 'Bayburt'),
('70', 'Karaman'),
('71', 'Kırıkkale'),
('72', 'Batman'),
('73', 'Şırnak'),
('74', 'Bartın'),
('75', 'Ardahan'),
('76', 'Iğdır'),
('77', 'Yalova'),
('78', 'Karabük'),
('79', 'Kilis'),
('80', 'Osmaniye'),
('81', 'Düzce');