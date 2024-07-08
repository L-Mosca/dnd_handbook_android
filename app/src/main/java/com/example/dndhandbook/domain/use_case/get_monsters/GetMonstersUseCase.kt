package com.example.dndhandbook.domain.use_case.get_monsters

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.base.DefaultList
import com.example.dndhandbook.domain.repository.monster.MonsterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMonstersUseCase @Inject constructor(private val repository: MonsterRepository) {

    operator fun invoke(): Flow<Resource<DefaultList>> = flow {
        try {
            emit(Resource.Loading())
            val monsterList = repository.fetchAllMonsters()
            emit(Resource.Success(data = monsterList))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}