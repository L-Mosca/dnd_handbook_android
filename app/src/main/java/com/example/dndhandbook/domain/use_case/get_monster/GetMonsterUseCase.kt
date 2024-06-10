package com.example.dndhandbook.domain.use_case.get_monster

import com.example.dndhandbook.common.Resource
import com.example.dndhandbook.domain.models.MonsterDetail
import com.example.dndhandbook.domain.models.toMonsterDetail
import com.example.dndhandbook.domain.repository.monster.MonsterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMonsterUseCase @Inject constructor(private val repository: MonsterRepository) {

    operator fun invoke(monsterIndex: String): Flow<Resource<MonsterDetail>> = flow {
        try {
            emit(Resource.Loading())
            val monsterDetail =
                repository.fetchMonsterDetail(monsterIndex)?.toMonsterDetail() ?: MonsterDetail()
            emit(Resource.Success(data = monsterDetail))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server. Check your internet connection"))
        }
    }
}