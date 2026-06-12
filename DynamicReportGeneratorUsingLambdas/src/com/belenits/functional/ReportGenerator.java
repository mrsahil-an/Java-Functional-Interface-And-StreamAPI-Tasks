package com.belenits.functional;

import java.util.List;

@FunctionalInterface
public interface ReportGenerator<T, R> {
    R generate(List<T> data);
}