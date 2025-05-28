package com.javaileri.studentmanager.controller;

import com.javaileri.studentmanager.model.Student;
import com.javaileri.studentmanager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    // ✅ Öğrenci ekleme (POST)
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    // ✅ Tüm öğrencileri listeleme (GET)
    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // ✅ Ada göre sıralama (STREAM + LAMBDA)
    @GetMapping("/sortedByName")
    public List<Student> getStudentsSortedByName() {
        return studentRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
    }

    // ✅ Belirli yaştan büyük öğrencileri getirme (STREAM + LAMBDA)
    @GetMapping("/filterByAge")
    public List<Student> getStudentsAboveAge(@RequestParam int minAge) {
        return studentRepository.findAll()
                .stream()
                .filter(student -> student.getAge() >= minAge)
                .collect(Collectors.toList());
    }

    // ✅ Öğrenci güncelleme (PUT)
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setAge(updatedStudent.getAge());
                    return studentRepository.save(student);
                })
                .orElseThrow(() -> new RuntimeException("Öğrenci bulunamadı: " + id));
    }

    // ✅ Öğrenci silme (DELETE)
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Silme işlemi başarılı.";
        } else {
            return "Öğrenci bulunamadı.";
        }
    }

    // ✅ Multithread örneği (arka planda işlem)
    @GetMapping("/multithreadTest")
    public String multithreadExample() {
        Runnable task = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread çalışıyor... Adım: " + i);
                try {
                    Thread.sleep(1000); // 1 saniye beklet
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread tamamlandı.");
        };

        Thread thread = new Thread(task);
        thread.start();

        return "Thread başlatıldı. Konsolu takip edin.";
    }

    // ✅ Generic metod örneği (Generic Programlama)
    public <T> void printGenericList(List<T> list) {
        list.forEach(System.out::println);
    }

    // ✅ Generic metod kullanımı
    @GetMapping("/printAll")
    public String printAllStudentsGeneric() {
        List<Student> students = studentRepository.findAll();
        printGenericList(students); // generic metod kullanımı
        return "Tüm öğrenciler konsola yazdırıldı.";
    }
}
