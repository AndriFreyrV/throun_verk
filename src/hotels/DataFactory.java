package hotels;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DataFactory {
    public DataFactory() {
    }

    public ArrayList<Hotel> getHotels() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        hotels.add(new Hotel(15000, "Iceland air hotel", "Akureyri", 25, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(30000, "Hótel KEA", "Akureyri",15, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Hotel Natura", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(25000, "Hotel Marina", "Reykjavík", 15, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(60000, "101 Hotel", "Reykjavík", 30, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(40000, "Ion Atventure hotel", "Nesjavellir", 15, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(30000, "Ion city hotel", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(34000, "Umi hotel", "Hvolsvollur", 7, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(13000, "Hotel Örk", "Hveragerði", 30, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Alda Hotel", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Silica Hotel", "Grindavík", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(8000, "The Barn", "Norðurfoss", 2, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(60000, "Black Beach Suites", "Norðurfoss", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(60000, "Hotel Berg", "Keflavík", 3, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(46000, "Hotel Glymur", "Skólasetur", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(13000, "Center Hotels Plaza", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Fosshótel Glacier Lagoon", "Öræfi", 7, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(6000, "Fossatún Camping Pods", "Fossatún", 50, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(68000, "360 Hotel and Spa", "Mosató", 25, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(58000, "Hotel Grímsborgir", "Selfoss", 20, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(31000, "Hotel Husafell", "Húsafell", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(5000, "REK Inn", "Reykjavík", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(21000, "Hotel Keflavik", "Keflavik", 40, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(17000, "Hotel South Coast", "Selfoss", 30, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Stracta Hotel", "Hella", 6, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(35000, "Hotel Katla", "Vík", 6, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "ODDSSON Hotel", "Reykjavik", 20, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(18000, "Grand Hotel", "Reykjavík", 80, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(8000, "Hilds Fisherman Village", "Hafnarfjörður", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Hotel Kriunes", "Kopavogur", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Icelandair Hotel Hamar", "Borgarnes", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "Galleri Laugarvatn", "Laugarvatn", 9, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(18000, "Hraunsnef Country Hotel", "Biskupsstungur", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Hotel Viking", "Hafnarfjörður", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(48000, "Hotel Rangá", "Hella", 15, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Nupan Deluxe", "Reykjanesbær", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(80000, "IStay Cottages", "Suðurnesjabær", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(23000, "Radisson Blu 1919 Hotel", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(23000, "Hotel Borg", "Reykjavík", 30, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Hotel Dyrholaey", "Dyrhólaey", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(23000, "Sand Hotel", "Reykjavík", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Hilton Nordica", "Reykjavík", 100, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Apotek Hotel", "Reykjavík", 20, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(9000, "Hotel Vellir", "Hafnarfjörður", 15, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(21000, "Icelandair hotel Marina", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(16000, "Hotel Odinsve", "Reykjavík", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Brú Guesthouse", "Hvolsvöllur", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Wilderness Center", "Egilsstaðir", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Lighthouse Inn", "Suðurnesjabær",5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(19000, "Fosshótel", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Hotel Cabin", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(16000, "Sandgerdi Cottages", "Sandgerði", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(25000, "Bragdavellir Cottages", "Djupivogur", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(13000, "Hotel Kjarnalundur", "Akureyri", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(16000, "Midgardur by Centerhotels", "Reykjavík", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Lava Apartments", "Akureyri", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(13000, "Hotel Framtid", "Djúpivogur", 15, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Hótel Smári", "Kópavogur", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(13000, "Hotel Stundarfriður", "Helgafellssveit", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Fosshotel Baron", "Reykjavík", 18, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(7000, "Blue House B&B", "Seltjarnarnes", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(22000, "Hotel Skaftafell", "Öræfi", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Hotel Orkin", "Reykjavík", 20, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(25000, "Reykjavik Residence Hotel", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Milk Factory", "Höfn", 1, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(24000, "Skuggi Hotel", "Reykjavík", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(8000, "Efstidalur II", "Laugarvatn", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(17000, "100 Hotel", "Reykjavík", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Hotel Smyrlaborg", "Jökulsárlón", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Malarhorn Guesthouse", "Drangsnes", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "Harbour Inn Guesthouse", "Bíldudalur", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Hótel Bjarkarlundur", "Reykhólahreppur", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "Hotel Djupavik", "Djúpavík", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(17000, "Hotel West", "Patreksfjörður", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "Holt Inn", "Flateyri", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(17000, "Guesthouse", "Dísarstaðir", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(18000, "Vogafjos farm resort", "Mývatn", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(25000, "Laxa Hotel", "Ásar", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(30000, "Hotel Hallormsstadur", "Egilsstaðir", 25, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(20000, "Hotel 1001 nott", "Egilsstaðir", 10, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(1500, "Hotel Raudarskrida", "Þingeyjarsveit", 7, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(18000, "Guesthouse Basar", "Grímsey", 3, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(18000, "Vogafjos Farm Resort", "Mývatn", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Torg Guesthouse", "Akureyri", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(19000, "Bjarg", "Borgarnes", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(13000, "Hotel Kjarnalundur", "Akureyri", 3, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Syslo Guesthouse", "Stykkishólmur", 6, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Akkeri Guesthouse", "Stykkishólmur", 6, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Gamla Rif", "Ólafsvík", 6, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "Bikers Paradise", "Ólafsvík", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(17000, "Fosshotel Hellnar", "Hella", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(19000, "Hotel Egilssen", "Stykkishólmur", 8, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(8000, "Modrudalur/Fjallabyrd", "Egilsstaðir", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(1100, "Stori-Bakki", "Egilsstaðir", 3, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(12000, "Sireksstaðir Farm holiday", "Vopnafjörður", 3, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(14000, "Hotel Tangi", "Vopnafjörður", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(10000, "Husey", "Vopnafjörður", 5, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));
        hotels.add(new Hotel(15000, "Alfheimar", "Borgarfjörður Eystri", 4, LocalDate.parse("01-04-2021", formatter), LocalDate.parse("01-04-2022", formatter)));

        return hotels;
    }
}
