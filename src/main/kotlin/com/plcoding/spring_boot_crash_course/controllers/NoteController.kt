package com.plcoding.spring_boot_crash_course.controllers

import com.plcoding.spring_boot_crash_course.database.model.Note
import com.plcoding.spring_boot_crash_course.database.repository.NoteRepository
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant

// https://localhost:8085/notes

@RestController
@RequestMapping("/api/notes}")
class NoteController(
    private val repository: NoteRepository
) {


    data class NoteRequest (
        val id: String?,
        val title: String,
        val content: String,
        val color: Long,
        val ownerId: String
    )

    data class NoteResponse(
        val id: String,
        val title: String,
        val content: String,
        val color: Long,
        val createdAt: Instant
    )

    @PostMapping()
    fun save(body: NoteRequest) {
        repository.save(
            Note(
                title = body.title,
                content = body.content,
                color = body.color,
                createdAt = Instant.now(),
                ownerId = ObjectId(body.ownerId)
            )
        )
    }

}