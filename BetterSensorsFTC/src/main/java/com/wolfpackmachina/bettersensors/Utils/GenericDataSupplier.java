package com.wolfpackmachina.bettersensors.Utils;

@FunctionalInterface
public interface GenericDataSupplier<T>{
    T getData();
}
