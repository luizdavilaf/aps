package com.example;

public class Date {
    public final int year;
    public final int month;
    public final int day;

    public Date(String data) {
        String[] dataInteira = data.split("/");
        int dia = Integer.parseInt(dataInteira[0]);
        int mes = Integer.parseInt(dataInteira[1]);
        int ano = Integer.parseInt(dataInteira[2]);
        if (dia > 31) {
            this.year = dia;
            this.month = mes;
            this.day = ano;
        } else {
            this.day = dia;
            this.month = mes;
            this.year = ano;
        }
        this.validaDate();
    }

    public Date(int year, int month, int day) {
        if (day > 365) {
            this.year = day;
            this.month = month;
            this.day = year;
        } else {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        //System.out.println(this.toString());
        this.validaDate();

    }

    public Date() {
        this.day = 01;
        this.month = 01;
        this.year = 1900;
    }

    public void validaDate() {
        if ((this.day > 31) | (this.day < 1) | ((this.month == 2) && (this.day > 29))) {
            throw new IllegalArgumentException("Dia inválido");
        }
        if ((this.month > 12) | (this.month < 1)) {
            throw new IllegalArgumentException("Mês inválido");
        }
        if ((this.year < 1900)) {
            throw new IllegalArgumentException("Ano inválido");
        }

    }

    public int getyear() {
        return year;
    }

    public int getmonth() {
        return month;
    }

    public int getday() {
        return day;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }

    public Date minusDays(int num) {
        if (this.day - num > 0) {
            return new Date(this.year, this.month, this.day - num);
        } else {
            int tamanhoMesAnterior = new Date(this.year, this.month - 1, this.day).monthLength();
            int dia = tamanhoMesAnterior - num + this.day;
            return new Date(this.year, this.month - 1, dia);
        }

    }

    /**
     * Soma um inteiro aos dias.
     * Conta apenas o primeiro mes da soma com os dias exatos.
     * A partir do segundo os meses terão duração de 30 dias.
     * 
     * @param num inteiro para somar
     * @return Date com os dias somados
     * PROBLEMA COM OS DIAS, RESOLVIDO USANDO O TOMORROW
     */
    /* public Date plusDays(int num) {
        int tamanhoDoMes = this.monthLength();
        int diasSomados = num + this.day;
        int ano;
        int mes;
        int dia=0;
        if (diasSomados <= tamanhoDoMes) {
            return new Date(this.year, this.month, this.day + num);
        } else if ((diasSomados > tamanhoDoMes) && (diasSomados <= 59)) { // 28+31=59
            mes = 1;
            dia = diasSomados - tamanhoDoMes;
            if ((this.month == 12) && (dia == 1)) {
                return new Date(this.year + 1, 01, dia);
            }
            return new Date(this.year, this.month + 1, dia);
        }
        ano = (this.year) + ((((this.month - 1) * 30) + tamanhoDoMes + num) / 30 / 12);
        mes = ((((this.month - 1) * 30) + tamanhoDoMes + num) / 30 % 12);
        dia = ((((this.month - 1) * 30) + tamanhoDoMes + num + dia) % 30);
        return new Date(ano, mes, dia);
    } */

    public Date plusDays(int num) {
        Date n = this;
         for(int i = 0; i < num; i++){
         n = n.tomorrow();
         }         
         return n;
    }

    public Date plusMonths(int num) {
        int mes = ((this.month + num) % 12);
        int ano = ((this.month + num) / 12) + this.year;
        return new Date(ano, mes, this.day);
    }

    public boolean before(Date data) {
        if (this.year < data.year) {
            return true;
        } else if ((this.year <= data.year) && (this.month < data.month)) {
            return true;
        } else if ((this.year <= data.year) && (this.month <= data.month) && (this.day < data.day)) {
            return true;
        }
        return false;
    }

    public boolean after(Date data) {
        if (this.year > data.year) {
            return true;
        } else if ((this.year >= data.year) && (this.month > data.month)) {
            return true;
        } else if ((this.year >= data.year) && (this.month >= data.month) && (this.day > data.day)) {
            return true;
        }
        return false;
    }

    public Date yesterday() {
        return new Date(this.year, this.month, this.day - 1);
    }

    public Date tomorrow() {        
        int tamanhoDoMes = this.monthLength();
        int diasSomados = 1 + this.day;
        int mes;
        int dia;
        if (diasSomados <= tamanhoDoMes) {
            return new Date(this.year, this.month, this.day + 1);
        } else if ((diasSomados > tamanhoDoMes)) {
            mes = 1;
            dia = diasSomados - tamanhoDoMes;
            if ((this.month == 12) && (dia == 1)) {
                return new Date(this.year + 1, 01, dia);
            }
            return new Date(this.year, this.month + 1, dia);
        }

        return this;
    }

    public int monthLength() {
        switch (this.month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (this.year % 4 == 0) {
                    if (this.year % 100 != 0) {
                        return 29;
                    }
                    if (this.year % 100 == 0) {
                        if (this.year % 400 == 0) {
                            return 29;
                        }
                    }
                } else {
                    return 28;
                }
            default:
                return 30;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Date other = (Date) obj;
        if (day != other.day)
            return false;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        return true;
    }
}
