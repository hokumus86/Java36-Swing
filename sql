--select kullaniciadi,sifre, id from kullanici where sifre='1' and kullaniciadi='hokumus'


  select kullaniciadi,sifre, id from kullanici where kullaniciadi like '%d%'
  order by id  
  
  
  insert into kullanici(kullaniciadi,sifre) 
  				values('derya','42'),
					('devrim' , 'araba')
					
					update kullanici set sifre='5'  where id=5
					
					delete from kullanici where id=1
