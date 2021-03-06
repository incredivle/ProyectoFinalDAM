package com.example.fuerm.gestionoficinatecnica.objetos;

/**
 * Created by fuerm on 27/04/2017.
 */

public class Facturacion {
    private Factura factura = new Factura();

    public class Factura {
        private String id_factura;
        private String cif;
        private DireccionFacturacion direccionFacturacion = new DireccionFacturacion();

        public Factura() {
        }

        public Factura(String id_factura, String cif, DireccionFacturacion direccionFacturacion) {
            this.id_factura = id_factura;
            this.cif = cif;
            this.direccionFacturacion = direccionFacturacion;
        }

        public class DireccionFacturacion{
            private String pais;
            private String provincia;
            private String municipio;
            private String calle;
            private int codigo_postal;

            public DireccionFacturacion() {
            }

            public DireccionFacturacion(String pais, String provincia, String municipio, String calle, int codigo_postal) {
                this.pais = pais;
                this.provincia = provincia;
                this.municipio = municipio;
                this.calle = calle;
                this.codigo_postal = codigo_postal;
            }

            public String getPais() {
                return pais;
            }

            public void setPais(String pais) {
                this.pais = pais;
            }

            public String getProvincia() {
                return provincia;
            }

            public void setProvincia(String provincia) {
                this.provincia = provincia;
            }

            public String getMunicipio() {
                return municipio;
            }

            public void setMunicipio(String municipio) {
                this.municipio = municipio;
            }

            public String getCalle() {
                return calle;
            }

            public void setCalle(String calle) {
                this.calle = calle;
            }

            public int getCodigo_postal() {
                return codigo_postal;
            }

            public void setCodigo_postal(int codigo_postal) {
                this.codigo_postal = codigo_postal;
            }
        }

        public String getId_factura() {
            return id_factura;
        }

        public void setId_factura(String id_factura) {
            this.id_factura = id_factura;
        }

        public String getCif() {
            return cif;
        }

        public void setCif(String cif) {
            this.cif = cif;
        }

        public DireccionFacturacion getDireccionFacturacion() {
            return direccionFacturacion;
        }

        public void setDireccionFacturacion(DireccionFacturacion direccionFacturacion) {
            this.direccionFacturacion = direccionFacturacion;
        }
    }


    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }
}
