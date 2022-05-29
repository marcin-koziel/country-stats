package ca.marcinkoziel.countrystats.beans;

public enum CountryType {

    AFGHANISTAN ("Afghanistan"),
    ALBANIA ("Albania"),
    ALGERIA ("Algeria"),
    ANDORRA ("Andorra"),
    ANGOLA ("Angola"),
    ANTIGUA_AND_BARBUDA ("Antigua and Barbuda"),
    ARGENTINA ("Argentina"),
    ARMENIA ("Armenia"),
    AUSTRALIA ("Australia"),
    AUSTRIA ("Austria"),
    AZERBAIJAN ("Azerbaijan"),
    BAHAMAS ("Bahamas"),
    BAHRAIN ("Bahrain"),
    BANGLADESH ("Bangladesh"),
    BARBADOS ("Barbados"),
    BELARUS ("Belarus"),
    BELGIUM ("Belgium"),
    BELIZE ("Belize"),
    BENIN ("Benin"),
    BHUTAN ("Bhutan"),
    BOLIVIA ("Bolivia"),
    BOSNIA_AND_HERZEGOVINA ("Bosnia and Herzegovina"),
    BOTSWANA ("Botswana"),
    BRAZIL ("Brazil"),
    BRUNEI_ ("Brunei "),
    BULGARIA ("Bulgaria"),
    BURKINA_FASO ("Burkina Faso"),
    BURUNDI ("Burundi"),
    COTE_D_IVOIRE ("Côte d'Ivoire"),
    CABO_VERDE ("Cabo Verde"),
    CAMBODIA ("Cambodia"),
    CAMEROON ("Cameroon"),
    CANADA ("Canada"),
    CENTRAL_AFRICAN_REPUBLIC ("Central African Republic"),
    CHAD ("Chad"),
    CHILE ("Chile"),
    CHINA ("China"),
    COLOMBIA ("Colombia"),
    COMOROS ("Comoros"),
    CONGO ("Congo (Congo-Brazzaville)"),
    COSTA_RICA ("Costa Rica"),
    CROATIA ("Croatia"),
    CUBA ("Cuba"),
    CYPRUS ("Cyprus"),
    CZECHIA ("Czechia (Czech Republic)"),
    DEMOCRATIC_REPUBLIC_OF_THE_CONGO ("Democratic Republic of the Congo"),
    DENMARK ("Denmark"),
    DJIBOUTI ("Djibouti"),
    DOMINICA ("Dominica"),
    DOMINICAN_REPUBLIC ("Dominican Republic"),
    ECUADOR ("Ecuador"),
    EGYPT ("Egypt"),
    EL_SALVADOR ("El Salvador"),
    EQUATORIAL_GUINEA ("Equatorial Guinea"),
    ERITREA ("Eritrea"),
    ESTONIA ("Estonia"),
    ESWATINI ("Eswatini (fmr. 'Swaziland')"),
    ETHIOPIA ("Ethiopia"),
    FIJI ("Fiji"),
    FINLAND ("Finland"),
    FRANCE ("France"),
    GABON ("Gabon"),
    GAMBIA ("Gambia"),
    GEORGIA ("Georgia"),
    GERMANY ("Germany"),
    GHANA ("Ghana"),
    GREECE ("Greece"),
    GRENADA ("Grenada"),
    GUATEMALA ("Guatemala"),
    GUINEA ("Guinea"),
    GUINEA_BISSAU ("Guinea-Bissau"),
    GUYANA ("Guyana"),
    HAITI ("Haiti"),
    HOLY_SEE ("Holy See"),
    HONDURAS ("Honduras"),
    HUNGARY ("Hungary"),
    ICELAND ("Iceland"),
    INDIA ("India"),
    INDONESIA ("Indonesia"),
    IRAN ("Iran"),
    IRAQ ("Iraq"),
    IRELAND ("Ireland"),
    ISRAEL ("Israel"),
    ITALY ("Italy"),
    JAMAICA ("Jamaica"),
    JAPAN ("Japan"),
    JORDAN ("Jordan"),
    KAZAKHSTAN ("Kazakhstan"),
    KENYA ("Kenya"),
    KIRIBATI ("Kiribati"),
    KUWAIT ("Kuwait"),
    KYRGYZSTAN ("Kyrgyzstan"),
    LAOS ("Laos"),
    LATVIA ("Latvia"),
    LEBANON ("Lebanon"),
    LESOTHO ("Lesotho"),
    LIBERIA ("Liberia"),
    LIBYA ("Libya"),
    LIECHTENSTEIN ("Liechtenstein"),
    LITHUANIA ("Lithuania"),
    LUXEMBOURG ("Luxembourg"),
    MADAGASCAR ("Madagascar"),
    MALAWI ("Malawi"),
    MALAYSIA ("Malaysia"),
    MALDIVES ("Maldives"),
    MALI ("Mali"),
    MALTA ("Malta"),
    MARSHALL_ISLANDS ("Marshall Islands"),
    MAURITANIA ("Mauritania"),
    MAURITIUS ("Mauritius"),
    MEXICO ("Mexico"),
    MICRONESIA ("Micronesia"),
    MOLDOVA ("Moldova"),
    MONACO ("Monaco"),
    MONGOLIA ("Mongolia"),
    MONTENEGRO ("Montenegro"),
    MOROCCO ("Morocco"),
    MOZAMBIQUE ("Mozambique"),
    MYANMAR ("Myanmar (formerly Burma)"),
    NAMIBIA ("Namibia"),
    NAURU ("Nauru"),
    NEPAL ("Nepal"),
    NETHERLANDS ("Netherlands"),
    NEW_ZEALAND ("New Zealand"),
    NICARAGUA ("Nicaragua"),
    NIGER ("Niger"),
    NIGERIA ("Nigeria"),
    NORTH_KOREA ("North Korea"),
    NORTH_MACEDONIA ("North Macedonia"),
    NORWAY ("Norway"),
    OMAN ("Oman"),
    PAKISTAN ("Pakistan"),
    PALAU ("Palau"),
    PALESTINE_STATE ("Palestine State"),
    PANAMA ("Panama"),
    PAPUA_NEW_GUINEA ("Papua New Guinea"),
    PARAGUAY ("Paraguay"),
    PERU ("Peru"),
    PHILIPPINES ("Philippines"),
    POLAND ("Poland"),
    PORTUGAL ("Portugal"),
    QATAR ("Qatar"),
    ROMANIA ("Romania"),
    RUSSIA ("Russia"),
    RWANDA ("Rwanda"),
    SAINT_KITTS_AND_NEVIS ("Saint Kitts and Nevis"),
    SAINT_LUCIA ("Saint Lucia"),
    SAINT_VINCENT_AND_THE_GRENADINES ("Saint Vincent and the Grenadines"),
    SAMOA ("Samoa"),
    SAN_MARINO ("San Marino"),
    SAO_TOME_AND_PRINCIPE ("Sao Tome and Principe"),
    SAUDI_ARABIA ("Saudi Arabia"),
    SENEGAL ("Senegal"),
    SERBIA ("Serbia"),
    SEYCHELLES ("Seychelles"),
    SIERRA_LEONE ("Sierra Leone"),
    SINGAPORE ("Singapore"),
    SLOVAKIA ("Slovakia"),
    SLOVENIA ("Slovenia"),
    SOLOMON_ISLANDS ("Solomon Islands"),
    SOMALIA ("Somalia"),
    SOUTH_AFRICA ("South Africa"),
    SOUTH_KOREA ("South Korea"),
    SOUTH_SUDAN ("South Sudan"),
    SPAIN ("Spain"),
    SRI_LANKA ("Sri Lanka"),
    SUDAN ("Sudan"),
    SURINAME ("Suriname"),
    SWEDEN ("Sweden"),
    SWITZERLAND ("Switzerland"),
    SYRIA ("Syria"),
    TAJIKISTAN ("Tajikistan"),
    TANZANIA ("Tanzania"),
    THAILAND ("Thailand"),
    TIMOR_LESTE ("Timor-Leste"),
    TOGO ("Togo"),
    TONGA ("Tonga"),
    TRINIDAD_AND_TOBAGO ("Trinidad and Tobago"),
    TUNISIA ("Tunisia"),
    TURKEY ("Turkey"),
    TURKMENISTAN ("Turkmenistan"),
    TUVALU ("Tuvalu"),
    UGANDA ("Uganda"),
    UKRAINE ("Ukraine"),
    UNITED_ARAB_EMIRATES ("United Arab Emirates"),
    UNITED_KINGDOM ("United Kingdom"),
    UNITED_STATES_OF_AMERICA ("United States of America"),
    URUGUAY ("Uruguay"),
    UZBEKISTAN ("Uzbekistan"),
    VANUATU ("Vanuatu"),
    VENEZUELA ("Venezuela"),
    VIETNAM ("Vietnam"),
    YEMEN ("Yemen"),
    ZAMBIA ("Zambia"),
    ZIMBABWE ("Zimbabwe");

    private String name;

    CountryType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
