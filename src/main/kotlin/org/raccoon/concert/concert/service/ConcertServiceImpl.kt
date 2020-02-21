package org.raccoon.concert.concert.service

import org.raccoon.concert.concert.model.ConcertVO
import org.raccoon.concert.concert.repositoy.ConcertRepository
import org.raccoon.concert.user.model.UserVO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ConcertServiceImpl(
    @Autowired
    val concertRepo : ConcertRepository
) : ConcertService{
    override fun getItem(concertId : Long): ConcertVO  {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var concert = concertRepo.findById(concertId)

        if(concert.isPresent)
            return concert.get()
    }

    override fun deleteItem(concertId : Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var result = concertRepo.deleteById(concertId)
        return result
    }

    override fun updateItem(key: Long): UserVO {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.


    }

}