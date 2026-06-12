package com.belenits.functional;

import com.belenits.model.FileData;

@FunctionalInterface
public interface FileProcessor {
    void process(FileData fileData);
}
