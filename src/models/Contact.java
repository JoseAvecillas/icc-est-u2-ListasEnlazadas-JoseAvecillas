package models;

import java.util.Objects;

public class Contact<T, U> {
    private T name;
    private U phone;

    public Contact(T name, U phone) {
        this.name = name;
        this.phone = phone;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public U getPhone() {
        return phone;
    }

    public void setPhone(U phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Teléfono: " + phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Mismo objeto
        if (obj == null || getClass() != obj.getClass()) return false;

        Contact<?, ?> other = (Contact<?, ?>) obj;

        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}